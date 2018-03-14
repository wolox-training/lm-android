package ar.com.wolox.android.training.ui.network.services;

import java.util.List;

import ar.com.wolox.android.training.ui.network.entities.NewsResponse;
import ar.com.wolox.android.training.ui.network.entities.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HomeService {

        @GET("/users/")
        Call<List<NewsResponse>> reposForId(@Query("userId") Integer userId);
}

