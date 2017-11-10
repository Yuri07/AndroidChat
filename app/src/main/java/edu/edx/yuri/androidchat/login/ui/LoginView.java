package edu.edx.yuri.androidchat.login.ui;

/**
 * Created by yuri_ on 31/05/2017.
 */

public interface LoginView {

    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    void handleSignUp();
    void handleSignIn();

    void navigateToMainScreen();
    void loginError(String error);

    void newUserSuccess();
    void newUserError(String error);

}
