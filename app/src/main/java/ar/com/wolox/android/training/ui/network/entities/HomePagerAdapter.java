package ar.com.wolox.android.training.ui.network.entities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ar.com.wolox.android.training.ui.home.NewsFragment;
import ar.com.wolox.android.training.ui.home.ProfileFragment;

public class HomePagerAdapter extends FragmentStatePagerAdapter {
    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            Fragment tabFragment = new NewsFragment();
            return tabFragment;
        } else {
            Fragment profileFragment = new ProfileFragment();
            return profileFragment;
        }

    }

    @Override
    public int getCount() {
        return 0;
    }
}
