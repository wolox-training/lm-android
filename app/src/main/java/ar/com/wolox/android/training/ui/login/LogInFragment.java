package ar.com.wolox.android.training.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ar.com.wolox.android.R;
import ar.com.wolox.android.training.ui.home.HomeActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class LogInFragment extends WolmoFragment<LogInPresenter> implements LogInView {

    private static final String USER = "USER";
    @BindView(R.id.fragment_login_terms) TextView mTermsTxt;
    @BindView(R.id.fragment_login_email_address_edit_text) EditText mEmailTxt;

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
            }else{
               // getPresenter().doLogin(mEmailTxt.getText().toString());
                SharedPreferences sharedPref = getActivity().getSharedPreferences(USER,Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(USER, mEmailTxt.getText().toString());
                editor.commit();
                Intent homeIntent = new Intent(getActivity(), HomeActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(homeIntent);
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


    @Override
    public void onLoginFinished() {

    }
}
