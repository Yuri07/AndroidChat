package edu.edx.yuri.androidchat.login;

/**
 * Created by yuri_ on 31/05/2017.
 */

public interface LoginRepository {

    void signUp(final String email, final String password);
    void signIn(String email, String password);
    void checkAlreadyAuthenticated();

}
