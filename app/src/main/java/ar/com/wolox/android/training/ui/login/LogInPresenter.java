package ar.com.wolox.android.training.ui.login;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.List;

import ar.com.wolox.android.R;
import ar.com.wolox.android.training.TrainingApplication;
import ar.com.wolox.android.training.ui.network.entities.UserResponse;
import ar.com.wolox.android.training.ui.network.services.LogInService;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LogInPresenter extends BasePresenter<LogInView> {

    private RetrofitServices mRetrofitServices;
    private SharedPreferences mSharedPreferences;
    private static final String USER = "USER";

    // Constructor
    public LogInPresenter(LogInView viewInstance) {
        super(viewInstance);
        mRetrofitServices = ((TrainingApplication) TrainingApplication.getInstance()).getRetrofitServices();
        mRetrofitServices.init();
        mSharedPreferences = ((TrainingApplication) TrainingApplication.getInstance()).getSharedPreferences(USER, Context.MODE_PRIVATE);
    }

    public void doLogin(String mEmailTxt, String mPassword, Context context) {
        LogInService service = mRetrofitServices.getService(LogInService.class);
        service.reposForUser(mEmailTxt).enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
                if (!response.body().isEmpty()) {
                    UserResponse userResponse = response.body().get(0);
                    if (userResponse.getPassword().equals(mPassword)) {
                        SharedPreferences.Editor editor = mSharedPreferences.edit();
                        editor.putString(USER, mEmailTxt);
                        editor.commit();
                        getView().onLoginFinished();
                    } else {
                        String error = context.getString(R.string.password_error);
                        getView().onLoginFailed(error);
                    }
                } else {
                    String error = context.getString(R.string.no_valid_user_name);
                    getView().onLoginFailed(error);
                }
            }
            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {
                String error=context.getString(R.string.check_internet_connection);
                getView().onLoginFailed(error);
                Log.e("LogInPresenter", t.getMessage(), t);
            }
        });
    }
}