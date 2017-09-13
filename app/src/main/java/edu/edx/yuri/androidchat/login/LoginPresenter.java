package edu.edx.yuri.androidchat.login;

import edu.edx.yuri.androidchat.login.events.LoginEvent;

/**
 * Created by yuri_ on 31/05/2017.
 */

public interface LoginPresenter {

    void onCreate();
    void onDestroy();
    void checkForAuthenticatedUser();
    void onEventMainThread(LoginEvent event);
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);

}
