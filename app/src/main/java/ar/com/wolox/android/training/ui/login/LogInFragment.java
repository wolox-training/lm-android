package ar.com.wolox.android.training.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import ar.com.wolox.android.R;
import ar.com.wolox.android.training.ui.home.HomeActivity;
import ar.com.wolox.android.training.ui.signup.SignUpActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class LogInFragment extends WolmoFragment<LogInPresenter> implements LogInView {

    private static final String USER = "USER";
    @BindView(R.id.fragment_login_signup_terms) TextView mTermsTxt;
    @BindView(R.id.fragment_login_email_edit_text) EditText mEmailTxt;
    @BindView(R.id.fragment_login_password_edit_text) EditText mPasswordTxt;
    @BindView(R.id.fragment_login_progress_bar) ProgressBar mProgressBar;

    // Fragments default constructors shouldn't be overridden, always prefer this method instead
    public static LogInFragment newInstance() {
        Bundle args = new Bundle();
        LogInFragment fragment = new LogInFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @OnClick(R.id.fragment_login_login_button)
        public void LogInValidate(){
        mEmailTxt.setError(null);
        mPasswordTxt.setError(null);
            if (requiredImputFieldsComplete(mEmailTxt)) {
                if (!isValidMail(mEmailTxt)) {
                    mEmailTxt.setError("Please insert a valid email address");
                } else {
                    mProgressBar.setVisibility(View.VISIBLE);
                    getPresenter().doLogin(mEmailTxt.getText().toString(),mPasswordTxt.getText().toString(),getContext());
                }
            } else {
                if (mEmailTxt.length() == 0)
                    mEmailTxt.setError("Please complete your email address");
                if (mPasswordTxt.length() == 0)
                    mPasswordTxt.setError("Please complete with your password");
            }
    }

    private boolean requiredImputFieldsComplete(EditText mEmailTxt) {
        return mEmailTxt.length() != 0 && mPasswordTxt.length() != 0;
    }

    private boolean isValidMail(EditText mEmailTxt) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(mEmailTxt.getText()).matches();
    }

    @OnClick(R.id.fragment_login_signup_button)
        public void SignUpCall(){
            Intent signUpIntent = new  Intent(getActivity(), SignUpActivity.class);
            startActivity(signUpIntent);
    }

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void setUi(View v) {
        super.setUi(v);
        mTermsTxt.setMovementMethod(LinkMovementMethod.getInstance());
        mPasswordTxt.setTransformationMethod(PasswordTransformationMethod.getInstance() );
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
        Toast.makeText(getContext(), "Log in succesfully", Toast.LENGTH_SHORT).show();
        mProgressBar.setVisibility(View.GONE);
        Intent homeIntent = new Intent(getActivity(), HomeActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(homeIntent);
    }

    @Override
    public void onLoginFailed(String error) {
        mProgressBar.setVisibility(View.GONE);
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }
}
