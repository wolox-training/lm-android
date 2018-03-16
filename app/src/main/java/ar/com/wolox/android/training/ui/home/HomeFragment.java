package ar.com.wolox.android.training.ui.home;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class HomeFragment extends WolmoFragment<HomePresenter> implements HomeView {

    @BindView(R.id.home_tab_layout) TabLayout mTabLayout;
    @BindView(R.id.home_pager) ViewPager mPager;
    @BindView(R.id.home_recycler_view) RecyclerView mRecyclerView;

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

    public void setListeners(TabLayout.Tab NewsTab, TabLayout.Tab ProfileTab){
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab == NewsTab) {
                    NewsTab.setIcon(R.drawable.ic_news_list_on);
                    ProfileTab.setIcon(R.drawable.ic_profile_off);
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
    }

    @Override
    public void setUi(View v) {
        super.setUi(v);

        //News Tab
        TabLayout.Tab NewsTab = mTabLayout.newTab();
        NewsTab.setText(getString(R.string.news_tab));

        //Profile Tab
        TabLayout.Tab ProfileTab = mTabLayout.newTab();
        ProfileTab.setText(getString(R.string.profile_tab));

        setListeners(NewsTab, ProfileTab);

        mTabLayout.addTab(NewsTab, true);
        mTabLayout.addTab(ProfileTab, false);
        mTabLayout.setTabTextColors(getResources().getColor(R.color.tab_color_unset), getResources().getColor(R.color.tab_color_set));
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.tab_color_set));

        mRecyclerView.setHasFixedSize(true);

    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    public void init() {
    }




}
