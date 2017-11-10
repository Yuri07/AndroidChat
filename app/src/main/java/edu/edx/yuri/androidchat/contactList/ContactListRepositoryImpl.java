package edu.edx.yuri.androidchat.contactList;

import com.google.firebase.database.ChildEventListener;

import edu.edx.yuri.androidchat.domain.FirebaseHelper;

/**
 * Created by yuri_ on 10/11/2017.
 */

public class ContactListRepositoryImpl implements ContactListRepository {

    private FirebaseHelper helper;

    private ChildEventListener contactListEventListener;

    public ContactListRepositoryImpl(){
        helper = FirebaseHelper.getInstance();
    }

    @Override
    public void signOff() {

    }

    @Override
    public String getCurrentEmail() {
        return null;
    }

    @Override
    public void removeContact(String email) {

    }

    @Override
    public void destroyContactListListener() {

    }

    @Override
    public void subscribeForContactListUpdates() {

    }

    @Override
    public void unSubscribeForContactListUpdates() {

    }

    @Override
    public void changeUserConnectionStatus(boolean online) {

    }
}
