package ar.com.wolox.android.LogIn.ui.login;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

public class LogInFragment extends WolmoFragment<LogInPresenter> implements LogInView {

    @BindView(R.id.fragment_login_terms) TextView mTermsTxt;
    @BindView(R.id.fragment_login_email_address_edit_text) EditText mEmailTxt;
    //@BindView(R.id.fragment_login_login_button) Button mLogInBtn;

    // Fragments default constructors shouldn't be overridden, always prefer this method instead
    public static LogInFragment newInstance() {
        Bundle args = new Bundle();
        LogInFragment fragment = new LogInFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @OnClick(R.id.fragment_login_login_button)
        public void LogInValidate(){
            if (mEmailTxt.length() == 0) {
                mEmailTxt.setError("Please complete your email address");
            }else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(mEmailTxt.getText()).matches()){
                    mEmailTxt.setError("Please insert a valid email address");
            }
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
