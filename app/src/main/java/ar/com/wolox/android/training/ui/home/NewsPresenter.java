package ar.com.wolox.android.training.ui.home;

import android.util.Log;

import java.util.Collections;
import java.util.Comparator;
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

    public void bringNews(int shownews) {
        //List<NewsResponse> newsResponse = new LinkedList<>();
        HomeService service = mRetrofitServices.getService(HomeService.class);
        service.repoNews().enqueue(new Callback<List<NewsResponse>>() {
            @Override
            public void onResponse(Call<List<NewsResponse>> call, Response<List<NewsResponse>> response) {
                List<NewsResponse> responseBody = new LinkedList<>();
                responseBody = response.body();
                Collections.sort(responseBody, new Comparator<NewsResponse>(){
                    public int compare(NewsResponse obj1, NewsResponse obj2)
                    {
                        return obj1.getCreatedAt().compareToIgnoreCase(obj2.getCreatedAt());
                    }
                });


                getView().bringNewsSuccess(responseBody);
            }

            @Override
            public void onFailure(Call<List<NewsResponse>> call, Throwable t) {
                String error="Check your Internet connection";
                getView().bringNewsFailed(error);
                Log.e("NewsPresenter", t.getMessage(), t);
            }
        });

        //
//        List<NewsResponse> newsResponse = new LinkedList<>();
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
//
//    NewsResponse news3 = new NewsResponse();
//        news3.setPicture("https://icil.files.wordpress.com/2014/11/rodriguez_juan_ramon_foto-carnet.jpg");
//        news3.setTitle("News 3");
//        news3.setText("Text 3");
//        news3.setCreatedAt(null);
//        news3.setLikes(null);
//        news3.setUserId(3);
//        newsResponse.add(news3);
//
//    NewsResponse news4 = new NewsResponse();
//        news4.setPicture("https://icil.files.wordpress.com/2014/11/rodriguez_juan_ramon_foto-carnet.jpg");
//        news4.setTitle("News 4");
//        news4.setText("Text 4");
//        news4.setCreatedAt(null);
//        news4.setLikes(null);
//        news4.setUserId(4);
//        newsResponse.add(news4);
//
//    NewsResponse news5 = new NewsResponse();
//        news5.setPicture("https://icil.files.wordpress.com/2014/11/rodriguez_juan_ramon_foto-carnet.jpg");
//        news5.setTitle("News 5");
//        news5.setText("Text 5");
//        news5.setCreatedAt(null);
//        news5.setLikes(null);
//        news5.setUserId(5);
//        newsResponse.add(news5);
//
//    NewsResponse news6 = new NewsResponse();
//        news6.setPicture("https://icil.files.wordpress.com/2014/11/rodriguez_juan_ramon_foto-carnet.jpg");
//        news6.setTitle("News 6");
//        news6.setText("Text 6");
//        news6.setCreatedAt(null);
//        news6.setLikes(null);
//        news6.setUserId(6);
//        newsResponse.add(news6);
//
//    NewsResponse news7 = new NewsResponse();
//        news7.setPicture("https://icil.files.wordpress.com/2014/11/rodriguez_juan_ramon_foto-carnet.jpg");
//        news7.setTitle("News 7");
//        news7.setText("Text 7");
//        news7.setCreatedAt(null);
//        news7.setLikes(null);
//        news7.setUserId(7);
//        newsResponse.add(news7);
//
//    NewsResponse news8 = new NewsResponse();
//        news8.setPicture("https://icil.files.wordpress.com/2014/11/rodriguez_juan_ramon_foto-carnet.jpg");
//        news8.setTitle("News 8");
//        news8.setText("Text 8");
//        news8.setCreatedAt(null);
//        news8.setLikes(null);
//        news8.setUserId(8);
//        newsResponse.add(news8);
//
//    NewsResponse news9 = new NewsResponse();
//        news9.setPicture("https://icil.files.wordpress.com/2014/11/rodriguez_juan_ramon_foto-carnet.jpg");
//        news9.setTitle("News 9");
//        news9.setText("Text 9");
//        news9.setCreatedAt(null);
//        news9.setLikes(null);
//        news9.setUserId(9);
//        newsResponse.add(news9);
//
//    NewsResponse news10 = new NewsResponse();
//        news10.setPicture("https://icil.files.wordpress.com/2014/11/rodriguez_juan_ramon_foto-carnet.jpg");
//        news10.setTitle("News 10");
//        news10.setText("Text 10");
//        news10.setCreatedAt(null);
//        news10.setLikes(null);
//        news10.setUserId(10);
//        newsResponse.add(news10);
//        //
//        List<NewsResponse> auxList = new LinkedList<>();
//        if (newsResponse.size() < 2*shownews)
//            getView().bringNewsSuccess(newsResponse);
//        else {
//            for (int i = 0; i < 2 * shownews; i++)
//                auxList.add(newsResponse.get(i));
//            getView().bringNewsSuccess(auxList);
//        }
    }
}
