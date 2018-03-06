package ar.com.wolox.android.training.ui.login;


import android.util.Log;

import java.util.List;

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

    // Constructor
    public LogInPresenter(LogInView viewInstance) {
        super(viewInstance);
    }

    public void doLogin(String mEmailTxt, String mPassword) {
        mRetrofitServices = ((TrainingApplication) TrainingApplication.getInstance()).getRetrofitServices();
        mRetrofitServices.init();
        LogInService service = mRetrofitServices.getService(LogInService.class);
        service.reposForUser(mEmailTxt).enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
                if (!response.body().isEmpty()) {
                    UserResponse userResponse = response.body().get(0);
                    if (userResponse.getPassword().equals(mPassword)) {
                        getView().onLoginFinished();
                    } else {
                        String error = "Password error";
                        getView().onLoginFailed(error);
                    }
                } else {
                    String error = "No valid user name";
                    getView().onLoginFailed(error);
                }
            }
            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {
                String error="FAIL";
                getView().onLoginFailed(error);
                Log.e("LogInPresenter", t.getMessage(), t);
            }
        });
    }
}