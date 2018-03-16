package ar.com.wolox.android.training.ui.home;

import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import ar.com.wolox.android.training.ui.network.entities.NewsResponse;
import ar.com.wolox.android.training.ui.network.entities.UserResponse;
import ar.com.wolox.android.training.ui.network.services.HomeService;
import ar.com.wolox.android.training.ui.network.services.LogInService;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsPresenter extends BasePresenter<NewsView> {
    private RetrofitServices mRetrofitServices;

    public NewsPresenter(NewsView viewInstance, RetrofitServices retrofitServices) {
        super(viewInstance);
        mRetrofitServices = retrofitServices;
        mRetrofitServices.init();
    }

    public void bringNews() {
        //List<NewsResponse> newsResponse = new LinkedList<>();
        HomeService service = mRetrofitServices.getService(HomeService.class);
        service.repoNews().enqueue(new Callback<List<NewsResponse>>() {
            @Override
            public void onResponse(Call<List<NewsResponse>> call, Response<List<NewsResponse>> response) {
                getView().bringNewsSuccess(response.body());
            }
            @Override
            public void onFailure(Call<List<NewsResponse>> call, Throwable t) {
                String error="Check your Internet connection";
                getView().bringNewsFailed(error);
                Log.e("NewsPresenter", t.getMessage(), t);
            }
        });

//        //
//        NewsResponse news1 = new NewsResponse();
//        news1.setPicture("https://yt3.ggpht.com/a-/AJLlDp0TFaxkKTbr1YMaEdj0KOLllMoFJcuWOIm4XA=s900-mo-c-c0xffffffff-rj-k-no");
//        news1.setTitle("News 1");
//        news1.setText("Text 1");
//        news1.setCreatedAt(null);
//        news1.setLikes(null);
//        news1.setUserId(1);
//        newsResponse.add(news1);
//
//        NewsResponse news2 = new NewsResponse();
//        news2.setPicture("https://icil.files.wordpress.com/2014/11/rodriguez_juan_ramon_foto-carnet.jpg");
//        news2.setTitle("News 2");
//        news2.setText("Text 2");
//        news2.setCreatedAt(null);
//        news2.setLikes(null);
//        news2.setUserId(2);
//        newsResponse.add(news2);
//        //
    }
}
