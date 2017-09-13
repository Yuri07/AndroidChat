package edu.edx.yuri.androidchat.login;

import edu.edx.yuri.androidchat.lib.EventBus;
import edu.edx.yuri.androidchat.lib.GreenRobotEventBus;
import edu.edx.yuri.androidchat.login.LoginPresenter;
import edu.edx.yuri.androidchat.login.ui.LoginView;

/**
 * Created by yuri_ on 31/05/2017.
 */

public class LoginPresenterImpl implements LoginPresenter {

    EventBus eventBus;
    LoginView loginView;
    LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView){
        this.loginView = loginView;
        this.eventBus = GreenRobotEventBus.getInstance();
        this.loginInteractor = new LoginInteractorImpl();

    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void checkForAuthenticatedUser() {
        if(loginView!=null){
            loginView.disableInputs();
            loginView.showProgress();
        }
        loginInteractor.checkAlreadyAutheticated();
    }
}
