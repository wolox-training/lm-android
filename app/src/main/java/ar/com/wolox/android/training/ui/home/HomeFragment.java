package ar.com.wolox.android.training.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends WolmoFragment<HomePresenter> implements HomeView {

    @BindView(R.id.home_news_tab) LinearLayout mNewsll;
    @BindView(R.id.home_profile_tab) LinearLayout mProfilell;
    @BindView(R.id.home_news_icon_on) ImageView mNewsOnimg;
    @BindView(R.id.home_news_icon_off) ImageView mNewsOffimg;
    @BindView(R.id.home_profile_icon_on) ImageView mProfileOnimg;
    @BindView(R.id.home_profile_icon_off) ImageView mProfileOffimg;
    @BindView(R.id.home_news_text_view) TextView mNewstxt;
    @BindView(R.id.home_profile_text_view) TextView mProfiletxt;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.home_news_tab)
    public void newsSet(){
        mNewsOnimg.setVisibility(View.VISIBLE);
        mNewsOffimg.setVisibility(View.GONE);
        mProfileOnimg.setVisibility(View.GONE);
        mProfileOffimg.setVisibility(View.VISIBLE);
        mNewstxt.setTextColor(0x8DD35F);
        mProfiletxt.setTextColor(0x000000);
    }

    @OnClick(R.id.home_profile_tab)
    public void profileSet(){
        mNewsOnimg.setVisibility(View.GONE);
        mNewsOffimg.setVisibility(View.VISIBLE);
        mProfileOnimg.setVisibility(View.VISIBLE);
        mProfileOffimg.setVisibility(View.GONE);
        mNewstxt.setTextColor(0x000000);
        mProfiletxt.setTextColor(0x8DD35F);
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
