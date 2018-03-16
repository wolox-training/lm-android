package ar.com.wolox.android.training.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import org.joda.time.DateTime;

import java.lang.reflect.Array;

import ar.com.wolox.android.training.ui.network.entities.HomePagerAdapter;

import ar.com.wolox.android.R;
import ar.com.wolox.android.training.TrainingApplication;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;

public class HomeFragment extends WolmoFragment<HomePresenter> implements HomeView {

    @BindView(R.id.home_tab_layout) TabLayout mTabLayout;
    @BindView(R.id.home_pager) ViewPager mPager;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void tabInit(){
        HomePagerAdapter mHomePagerAdapter;
        mHomePagerAdapter = new HomePagerAdapter(getActivity().getSupportFragmentManager());
        mPager.setAdapter(mHomePagerAdapter);

        //News Tab
        TabLayout.Tab NewsTab = mTabLayout.newTab();
        NewsTab.setText("News");

        //Profile Tab
        TabLayout.Tab ProfileTab = mTabLayout.newTab();
        ProfileTab.setText("Profile");

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPager.setCurrentItem(tab.getPosition());
                if(tab == NewsTab) {
                    NewsTab.setIcon(R.drawable.ic_news_list_on);
                    ProfileTab.setIcon(R.drawable.ic_profile_off);
                    mPager.setCurrentItem(tab.getPosition());
                    //getPresenter().bringNews();
                }else {
                    NewsTab.setIcon(R.drawable.ic_news_list_off);
                    ProfileTab.setIcon(R.drawable.ic_profile_on);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mTabLayout.addTab(NewsTab, true);
        mTabLayout.addTab(ProfileTab, false);
        mTabLayout.setTabTextColors(Color.parseColor("#a5a8a9"), Color.parseColor("#8DC63F"));
        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#8DC63F"));
    }

    @Override
    public int layout() { return R.layout.fragment_home;}

    @Override
    public void setUi(View v) { super.setUi(v); }



    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    public void init() {
        tabInit();
    }
}


