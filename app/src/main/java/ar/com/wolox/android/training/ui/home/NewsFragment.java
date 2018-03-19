package ar.com.wolox.android.training.ui.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.joda.time.DateTime;

import java.lang.reflect.Array;
import java.util.List;

import ar.com.wolox.android.R;
import ar.com.wolox.android.training.TrainingApplication;
import ar.com.wolox.android.training.ui.home.HomePresenter;
import ar.com.wolox.android.training.ui.home.HomeView;
import ar.com.wolox.android.training.ui.network.entities.NewsResponse;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;

public class NewsFragment extends WolmoFragment<NewsPresenter> implements NewsView {

    @BindView(R.id.home_recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.home_news_swipe) SwipeRefreshLayout mSwipeRefreshLayout;
    Integer showNews = 1;
    private RecyclerView.Adapter mNewsAdapter;
    private RecyclerView.LayoutManager mNewsLayoutManager;

    @Override
    public void bringNewsSuccess(List<NewsResponse> newsResponse) {
        mNewsAdapter = new NewsAdapter(newsResponse);
        mRecyclerView.setAdapter(mNewsAdapter);
    }

    @Override
    public void bringNewsFailed(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public int layout() {
        return R.layout.fragment_home_recycler;
    }

    @Override
    public NewsPresenter createPresenter() {
        return new NewsPresenter(this, ((TrainingApplication) TrainingApplication.getInstance()).getRetrofitServices());
    }



    @Override
    public void init() {
        //mRecyclerView.setHasFixedSize(true);

        mNewsLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mNewsLayoutManager);
        getPresenter().bringNews(showNews);
        showNews++;
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().bringNews(showNews);
                showNews++;
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}

