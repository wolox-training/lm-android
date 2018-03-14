package ar.com.wolox.android.training.ui.login;

public interface LogInView {
    void onLoginFinished(Integer id);
    void onLoginFailed(String error);
}
