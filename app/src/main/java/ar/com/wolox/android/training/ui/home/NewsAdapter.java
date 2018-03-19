package ar.com.wolox.android.training.ui.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;

import org.ocpsoft.prettytime.PrettyTime;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.wolox.android.R;
import ar.com.wolox.android.training.TrainingApplication;
import ar.com.wolox.android.training.ui.network.entities.NewsResponse;
import butterknife.BindView;
import butterknife.ButterKnife;
//import org.joda.time.Da

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    List<NewsResponse> newsList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_news_image)
        SimpleDraweeView mNewsimg;
        @BindView(R.id.home_news_title)
        TextView mNewsTitletxt;
        @BindView(R.id.home_news_text)
        TextView mNewsTexttxt;
        @BindView(R.id.home_news_time)
        TextView mNewsTimetxt;
        @BindView(R.id.home_news_like)
        ImageView mNewsLikeImg;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public NewsAdapter(List<NewsResponse> newsResponseList) {
        newsList = newsResponseList;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_news, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsResponse news = newsList.get(position);
        Uri uri = Uri.parse(news.getPicture());
//        holder.mNewsimg.setImageURI(uri);
        holder.mNewsimg.setImageURI(uri);
        holder.mNewsTitletxt.setText(news.getTitle());
        holder.mNewsTexttxt.setText(news.getText());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-ddTHH:mm:ssssssZ");
        String myDate = dateFormat.format(news.getCreatedAt());
//        String[] parts = news.getCreatedAt().split("-");
//        String year = parts[0];
//        String month = parts[1];
//        String rest = parts[2];
//        parts = rest.split("T");
//        String day = parts[0];
//        rest = parts[1];
//        parts = rest.split(":");
//        String hour = parts[0];
//        String min = parts[1];
//        rest = parts[2];
//        parts = rest.split("Z");
//        String seg = parts[0];
        //PrettyTime p = new PrettyTime();
        //holder.mNewsTimetxt.setText(p.format(mTime) + p.format(new Date(System.currentTimeMillis())));
        holder.mNewsLikeImg.setImageResource(R.drawable.ic_like_off);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

}
