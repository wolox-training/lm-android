package ar.com.wolox.android.training.ui.signup;

import android.os.Bundle;
import android.view.View;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

public class SignUpFragment extends WolmoFragment<SignUpPresenter> implements SignUpView {

    public static SignUpFragment newInstance() {
        Bundle args = new Bundle();
        SignUpFragment fragment = new SignUpFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int layout() {
        return R.layout.fragment_signup;
    }

    @Override
    public void setUi(View v) {
        super.setUi(v);
    }

    @Override
    public SignUpPresenter createPresenter() {
        return new SignUpPresenter(this);
    }

    @Override
    public void init() {
    }




}
