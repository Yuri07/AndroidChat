package edu.edx.yuri.androidchat.contactList.ui;

import edu.edx.yuri.androidchat.contactList.entities.User;

/**
 * Created by yuri_ on 13/09/2017.
 */

public interface OnItemClickListener {

    void onItemClick(User user);
    void onItemLongClick(User user);

}
