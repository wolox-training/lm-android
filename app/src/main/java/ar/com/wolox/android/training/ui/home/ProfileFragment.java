package ar.com.wolox.android.training.ui.home;

import android.support.v4.app.Fragment;

import ar.com.wolox.android.R;
import ar.com.wolox.android.training.ui.home.HomePresenter;
import ar.com.wolox.android.training.ui.home.HomeView;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

public class ProfileFragment extends WolmoFragment<HomePresenter> implements HomeView {
    @Override
    public void bringNewsFailed(String error) { }

    @Override
    public int layout() {
        return R.layout.fragment_home_profile;
    }

    @Override
    public HomePresenter createPresenter() {
        return null;
    }

    @Override
    public void init() { }
}
