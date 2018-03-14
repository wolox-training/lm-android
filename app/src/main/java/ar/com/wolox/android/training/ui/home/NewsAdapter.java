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
import org.ocpsoft.prettytime.PrettyTime;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Date;

import ar.com.wolox.android.R;
import butterknife.BindView;
//import org.joda.time.Da

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private String mPicture;
    private String mTitle;
    private String mText;
    private DateTime mTime;
    private Array mLikes;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mNewsimg;
        public TextView mNewsTitletxt;
        public TextView mNewsTexttxt;
        public TextView mNewsTimetxt;
        public ImageView mNewsLikeImg;

            public ViewHolder(View v) {
                super(v);
            }
        }

        public NewsAdapter(String NewsPicture, String NewsTitle, String NewsText, DateTime NewsTime, Array NewsLikes){
            mPicture =  NewsPicture;
            mTitle = NewsTitle;
            mText = NewsText;
            mTime = NewsTime;
            mLikes = NewsLikes;
        }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_news, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Uri uri = Uri.parse(mPicture);
        holder.mNewsimg.setImageURI(uri);
        holder.mNewsTitletxt.setText(mTitle);
        holder.mNewsTexttxt.setText(mText);
        //PrettyTime p = new PrettyTime();
        //holder.mNewsTimetxt.setText(p.format(mTime) + p.format(new Date(System.currentTimeMillis())));
        holder.mNewsLikeImg.setImageResource(R.drawable.ic_like_off);
    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
