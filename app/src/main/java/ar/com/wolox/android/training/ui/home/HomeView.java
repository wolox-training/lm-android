package ar.com.wolox.android.training.ui.home;

import org.joda.time.DateTime;

import java.lang.reflect.Array;

public interface HomeView {
    void bringNewsSuccess(String NewsPicture, String NewsTitle, String NewsText, DateTime NewsTime, Array NewsLikes);
    void bringNewsFailed(String error);
}
