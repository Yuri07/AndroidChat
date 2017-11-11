package edu.edx.yuri.androidchat.chat;

import edu.edx.yuri.androidchat.chat.events.ChatEvent;

/**
 * Created by yuri_ on 10/11/2017.
 */

public interface ChatPresenter {

    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void setChatRecipient(String recipient);

    void sendMessage(String msg);
    void onEventMainThread(ChatEvent event);

}
