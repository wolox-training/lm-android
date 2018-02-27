package ar.com.wolox.android.LogIn.ui.login;


import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

public class LogInActivity extends WolmoActivity {

    @Override
    protected int layout() {
        return R.layout.activity_base;
    }

    @Override
    protected void init() {
        replaceFragment(R.id.activity_base_content, LogInFragment.newInstance());
    }


}
