package edu.edx.yuri.androidchat.contactList;

/**
 * Created by yuri_ on 31/05/2017.
 */

public interface ContactListInteractor {

    void subscribeForContactEvents();
    void unSubscribeForContactEvents();
    void destroyContactListListener();
    void removeContact(String email);

}
