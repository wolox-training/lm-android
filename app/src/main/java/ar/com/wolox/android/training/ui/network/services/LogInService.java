package ar.com.wolox.android.training.ui.network.services;

import java.util.List;

import ar.com.wolox.android.training.ui.network.entities.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LogInService {

        @GET("/users/")
        Call<List<UserResponse>> reposForUser(@Query("email") String email);

}

