package ar.com.wolox.android.training.ui.home;


import android.util.Log;

import java.util.List;

import ar.com.wolox.android.training.TrainingApplication;
import ar.com.wolox.android.training.ui.login.LogInView;
import ar.com.wolox.android.training.ui.network.entities.NewsResponse;
import ar.com.wolox.android.training.ui.network.entities.UserResponse;
import ar.com.wolox.android.training.ui.network.services.HomeService;
import ar.com.wolox.android.training.ui.network.services.HomeService;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter extends BasePresenter<HomeView> {

    private RetrofitServices mRetrofitServices;

    // Constructor
    public HomePresenter(HomeView viewInstance, RetrofitServices retrofitServices) {
        super(viewInstance);
        mRetrofitServices = retrofitServices;
        mRetrofitServices.init();
    }

    public void bringNews(Integer mUserId){
        HomeService service = mRetrofitServices.getService(HomeService.class);
        service.reposForId(mUserId).enqueue(new Callback<List<NewsResponse>>() {
            @Override
            public void onResponse(Call<List<NewsResponse>> call, Response<List<NewsResponse>> response) {
                if (!response.body().isEmpty()) {
                    NewsResponse newsResponse = response.body().get(0);
                        getView().bringNewsSuccess(newsResponse.getPicture(),newsResponse.getTitle(), newsResponse.getText(),newsResponse.getCreatedAt(),newsResponse.getLikes());
                } else {
                    String error = "No news available";
                    getView().bringNewsFailed(error);
                }
            }
            @Override
            public void onFailure(Call<List<NewsResponse>> call, Throwable t) {
                String error="Check your Internet connection";
                getView().bringNewsFailed(error);
                Log.e("LogInPresenter", t.getMessage(), t);
            }
        });
    }
}
