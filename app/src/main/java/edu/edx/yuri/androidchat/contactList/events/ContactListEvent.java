package edu.edx.yuri.androidchat.contactList.events;

import edu.edx.yuri.androidchat.contactList.entities.User;

/**
 * Created by yuri_ on 10/11/2017.
 */

public class ContactListEvent {

    private User user;
    private int eventType;

    public final static int onContactAdded = 0;
    public final static int onContactChanged = 1;
    public final static int onContactRemoved = 2;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

}
