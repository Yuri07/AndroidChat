package edu.edx.yuri.androidchat.addcontact;

import edu.edx.yuri.androidchat.addcontact.AddContactEvent.AddContactEvent;

/**
 * Created by yuri_ on 10/11/2017.
 */

public interface AddContactPresenter {

    void onShow();
    void onDestroy();

    void addContact(String email);
    void onEventMainThread(AddContactEvent event);

}
