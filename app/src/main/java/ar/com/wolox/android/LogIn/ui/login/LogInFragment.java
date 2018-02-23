package ar.com.wolox.android.LogIn.ui.login;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

public class LogInFragment extends WolmoFragment<LogInPresenter> implements LogInView {

    @BindView(R.id.fragment_login_terms) TextView mTermsTxt;

    // Fragments default constructors shouldn't be overridden, always prefer this method instead
    public static LogInFragment newInstance() {
        Bundle args = new Bundle();
        LogInFragment fragment = new LogInFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void setUi(View v) {
        super.setUi(v);
        mTermsTxt.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public LogInPresenter createPresenter() {
        return new LogInPresenter(this);
    }

    @Override
    public void init() {
    }

}
