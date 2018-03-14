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
    }

    public void bringNews() {
        NewsResponse newsResponse = null;
        getView().bringNewsSuccess(newsResponse.getPicture(), newsResponse.getTitle(), newsResponse.getText(), newsResponse.getCreatedAt(), newsResponse.getLikes());
    }
}
