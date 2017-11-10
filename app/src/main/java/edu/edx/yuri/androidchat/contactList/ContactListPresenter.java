package edu.edx.yuri.androidchat.contactList;

import edu.edx.yuri.androidchat.contactList.events.ContactListEvent;

/**
 * Created by yuri_ on 10/11/2017.
 */

public interface ContactListPresenter {

    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void onEventMainThread(ContactListEvent event);

}
