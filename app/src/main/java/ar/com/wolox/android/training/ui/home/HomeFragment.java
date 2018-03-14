package ar.com.wolox.android.training.ui.home;

import android.os.Bundle;
import android.view.View;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

public class HomeFragment extends WolmoFragment<HomePresenter> implements HomeView {

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int layout() {
        return R.layout.fragment_home;
    }

    @Override
    public void setUi(View v) {
        super.setUi(v);
    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    public void init() {
    }




}
