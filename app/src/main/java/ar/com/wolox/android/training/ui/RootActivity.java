package ar.com.wolox.android.training.ui;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import ar.com.wolox.android.R;
import ar.com.wolox.android.training.ui.home.HomeActivity;
import ar.com.wolox.android.training.ui.login.LogInActivity;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

public class RootActivity extends WolmoActivity {

    private static final String USER = "USER";
    private static final String DefaultUSER = "DefaultUser";

    @Override
    protected int layout() {
        return R.layout.activity_base;
    }

    @Override
    protected void init() {
        SharedPreferences sharedPref = this.getSharedPreferences(USER,Context.MODE_PRIVATE);
        String userKey = sharedPref.getString(USER,DefaultUSER);
        if (userKey.equals(DefaultUSER)) {
            // Call LogInActivity
            Intent logInIntent = new Intent(this, LogInActivity.class);
            logInIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(logInIntent);
        }else {
            // Call HomeActivity
            Intent homeIntent = new Intent(this, HomeActivity.class);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(homeIntent);
        }
    }
}
