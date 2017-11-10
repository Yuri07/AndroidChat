package edu.edx.yuri.androidchat.contactList;

/**
 * Created by yuri_ on 10/11/2017.
 */

public interface ContactListRepository {

    void signOff();
    String getCurrentEmail();
    void removeContact(String email);
    void destroyContactListListener();
    void subscribeForContactListUpdates();
    void unSubscribeForContactListUpdates();
    void changeUserConnectionStatus(boolean online);

}
