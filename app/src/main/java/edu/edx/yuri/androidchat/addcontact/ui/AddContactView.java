package edu.edx.yuri.androidchat.addcontact.ui;

/**
 * Created by yuri_ on 10/11/2017.
 */

public interface AddContactView {

    void showInput();
    void hideInput();
    void showProgress();
    void hideProgress();

    void contactAdded();
    void contactNotAdded();

}
