package ar.com.wolox.android.training.ui.home;


import android.support.design.widget.TabLayout;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

public class HomeActivity extends WolmoActivity {

    @Override
    protected int layout() {
        return R.layout.activity_base;
    }

    @Override
    protected void init() {
        replaceFragment(R.id.activity_base_content, HomeFragment.newInstance());
    }


}
