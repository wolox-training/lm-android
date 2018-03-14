package ar.com.wolox.android.training.ui;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.List;

import ar.com.wolox.android.R;
import ar.com.wolox.android.training.TrainingApplication;
import ar.com.wolox.android.training.ui.home.HomeActivity;
import ar.com.wolox.android.training.ui.login.LogInActivity;
import ar.com.wolox.android.training.ui.network.entities.UserResponse;
import ar.com.wolox.android.training.ui.network.services.LogInService;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RootActivity extends WolmoActivity {

    private static final String USER = "USER";
    private static final String DefaultUSER = "DefaultUser";
    private RetrofitServices mRetrofitServices;

    public void serverNoResponse(){
        Intent logInIntent = new Intent(this, LogInActivity.class);
        logInIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(logInIntent);
    }

    public void serverResponseSuccess(Integer id){
        Intent homeIntent = new Intent(this, HomeActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        homeIntent.putExtra("UserId", id);
        startActivity(homeIntent);
    }

    @Override
    protected int layout() {
        return R.layout.activity_base;
    }

    @Override
    protected void init() {

        //Obtaining key-value
        SharedPreferences sharedPref = this.getSharedPreferences(USER, Context.MODE_PRIVATE);
        String userKey = sharedPref.getString(USER, DefaultUSER);

        //Connecting to server
        mRetrofitServices = ((TrainingApplication) TrainingApplication.getInstance()).getRetrofitServices();
        mRetrofitServices.init();
        LogInService service = mRetrofitServices.getService(LogInService.class);

        //Comparing key-value with server information
        service.reposForUser(userKey).enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
                if (!response.body().isEmpty()) {
                    UserResponse userResponse = response.body().get(0);
                    serverResponseSuccess(userResponse.getId());
                } else {
                    // Call LogInActivity
                    serverNoResponse();
                }
            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t){
                serverNoResponse();
            }
        });
    }
}


