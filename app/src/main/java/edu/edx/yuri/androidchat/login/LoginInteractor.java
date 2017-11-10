package edu.edx.yuri.androidchat.login;

/**
 * Created by yuri_ on 31/05/2017.
 */

public interface LoginInteractor {

    void checkAlreadyAutheticated();
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);

}
