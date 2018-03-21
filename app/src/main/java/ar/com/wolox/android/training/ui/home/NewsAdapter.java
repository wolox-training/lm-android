package ar.com.wolox.android.training.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.ocpsoft.prettytime.PrettyTime;

import java.util.ArrayList;
import java.util.List;

import ar.com.wolox.android.R;
import ar.com.wolox.android.training.ui.network.entities.IdEvent;
import ar.com.wolox.android.training.ui.network.entities.NewsResponse;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.renderscript.Element.DataKind.USER;
//import org.joda.time.Da

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    List<NewsResponse> newsList = new ArrayList<>();
    int userId;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_news_image) SimpleDraweeView mNewsimg;
        @BindView(R.id.home_news_title) TextView mNewsTitletxt;
        @BindView(R.id.home_news_text)  TextView mNewsTexttxt;
        @BindView(R.id.home_news_time)  TextView mNewsTimetxt;
        @BindView(R.id.home_news_like)  ImageView mNewsLikeImg;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public NewsAdapter(List<NewsResponse> newsResponseList, int id) {
        newsList = newsResponseList;
        userId = id;
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
        holder.mNewsimg.setImageURI(uri);
        holder.mNewsTitletxt.setText(news.getTitle());
        holder.mNewsTexttxt.setText(news.getText());
        PrettyTime p = new PrettyTime();
        String auxDate = p.format(news.getCreatedAt().toDate());
        auxDate = auxDate.replace("years ago","y");
        holder.mNewsTimetxt.setText(auxDate);
        boolean on_off = false;
        for (int i = 0; i < news.getLikes().size(); i++) {
            if (news.getLikes().get(i) == userId) {
                on_off = true;
            }
        }
        if (on_off == true) {
            holder.mNewsLikeImg.setImageResource(R.drawable.ic_like_on);
            } else {
            holder.mNewsLikeImg.setImageResource(R.drawable.ic_like_off);
        }
        //EventBus.getDefault().unregister(this);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
