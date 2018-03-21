package ar.com.wolox.android.training.ui.home;

import android.view.View;
import android.widget.ImageView;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class DetailsFragment extends WolmoFragment<DetailsPresenter> {
    @BindView(R.id.news_like_logo) ImageView mDetailPicImg;

    @OnClick(R.id.news_like_logo)
    public void setLike(){
        mDetailPicImg.setImageResource(R.drawable.ic_like_on);
    }

    @Override
    public int layout() {
        return R.layout.fragment_news_detail;
    }

    @Override
    public DetailsPresenter createPresenter() {
        return null;
    }

    @Override
    public void init() {
    }


}