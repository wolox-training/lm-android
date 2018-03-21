package ar.com.wolox.android.training.ui.login;

public interface LogInView {
    void onLoginFinished(int userId);
    void onLoginFailed(String error);
}
