package edu.edx.yuri.androidchat.login;

/**
 * Created by yuri_ on 31/05/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {
    private LoginRepository loginRepository;

    public LoginInteractorImpl(){
        this.loginRepository = new LoginRepositoryImpl();
    }

    @Override
    public void checkAlreadyAutheticated() {
        loginRepository.checkAlreadyAuthenticated();
    }

    @Override
    public void doSignUp(String email, String password) {
        loginRepository.signUp(email, password);
    }

    @Override
    public void doSignIn(String email, String password) {
        loginRepository.signIn(email, password);
    }
}
