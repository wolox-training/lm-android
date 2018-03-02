package ar.com.wolox.android.training.ui.login;


import android.widget.TextView;

import ar.com.wolox.wolmo.core.presenter.BasePresenter;

public class LogInPresenter extends BasePresenter<LogInView> {

    // Constructor
    public LogInPresenter(LogInView viewInstance) {
        super(viewInstance);
    }


    public void doLogin(TextView mEmailTxt, TextView mPassword) {

        //getView().onLoginFinished();
    }
}