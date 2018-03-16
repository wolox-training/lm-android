package ar.com.wolox.android.training.ui.home;

import org.joda.time.DateTime;

import java.lang.reflect.Array;
import java.util.List;

import ar.com.wolox.android.training.ui.network.entities.NewsResponse;

public interface NewsView {
        void bringNewsSuccess(List<NewsResponse> newsResponse);
        void bringNewsFailed(String error);
}
