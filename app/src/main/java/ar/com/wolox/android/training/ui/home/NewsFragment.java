package ar.com.wolox.android.training.ui.home;

import ar.com.wolox.android.R;
import ar.com.wolox.android.training.ui.home.HomePresenter;
import ar.com.wolox.android.training.ui.home.HomeView;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

public class NewsFragment extends WolmoFragment<HomePresenter> implements HomeView {
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//        return inflater.inflate(R.layout.fragment_home_recycler,container,false);
//    }

    @Override
    public void bringNewsFailed(String error) {

    }

    @Override
    public int layout() {
        return R.layout.fragment_home_recycler;
    }

    @Override
    public HomePresenter createPresenter() {
        return null;
    }

    @Override
    public void init() {

    }
}

