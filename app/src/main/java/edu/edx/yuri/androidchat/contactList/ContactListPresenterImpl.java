package edu.edx.yuri.androidchat.contactList;

import edu.edx.yuri.androidchat.contactList.events.ContactListEvent;
import edu.edx.yuri.androidchat.contactList.ui.ContactListView;
import edu.edx.yuri.androidchat.lib.EventBus;
import edu.edx.yuri.androidchat.lib.GreenRobotEventBus;

/**
 * Created by yuri_ on 10/11/2017.
 */

public class ContactListPresenterImpl implements ContactListPresenter {

    EventBus eventBus;
    ContactListView contactListView;
    ContactListSessionInteractor contactListSessionInteractor;
    ContactListInteractor contactListInteractor;

    public ContactListPresenterImpl(ContactListView contactListView){
        this.eventBus = GreenRobotEventBus.getInstance();
        this.contactListView = contactListView;
        this.contactListSessionInteractor = new ContactListSessionInteractorImpl();
        this.contactListInteractor = new ContactListInteractorImpl();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void signOff() {

    }

    @Override
    public String getCurrentUserEmail() {
        return null;
    }

    @Override
    public void removeContact(String email) {

    }

    @Override
    public void onEventMainThread(ContactListEvent event) {

    }
}
