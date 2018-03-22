package ar.com.wolox.android.training.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
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

    private RecyclerView.Adapter mNewsAdapter;
    private RecyclerView.LayoutManager mNewsLayoutManager;
    private static final String ID = "ID";
    private static final int DefaultID = 0;

    @Override
    public void bringNewsSuccess(List<NewsResponse> newsResponse) {
        SharedPreferences sharedPref = getActivity().getSharedPreferences(ID, Context.MODE_PRIVATE);
        int id = sharedPref.getInt(ID, DefaultID);

        mNewsAdapter = new NewsAdapter(newsResponse,id);
        mRecyclerView.setAdapter(mNewsAdapter);
    }

    @Override
    public void bringNewsFailed(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void noNews(String error){
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
        mRecyclerView.setHasFixedSize(true);

        mNewsLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mNewsLayoutManager);
        getPresenter().bringNews();
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {

                    return true;
                }

            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View ChildView = rv.findChildViewUnder(e.getX(),e.getY());

                if(ChildView != null && gestureDetector.onTouchEvent(e)) {

                    int RecyclerViewItemPosition = rv.getChildAdapterPosition(ChildView);

                    Toast.makeText(getActivity(), Integer.toString(RecyclerViewItemPosition), Toast.LENGTH_LONG).show();
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });


        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().bringNews();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}

