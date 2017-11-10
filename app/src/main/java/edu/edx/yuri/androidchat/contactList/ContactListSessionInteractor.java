package edu.edx.yuri.androidchat.contactList;

/**
 * Created by yuri_ on 10/11/2017.
 */

public interface ContactListSessionInteractor {

    void signOff();
    String getCurrentUserEmail();
    void changeConnectionStatus(boolean online);

}
