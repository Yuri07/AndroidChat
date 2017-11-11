package edu.edx.yuri.androidchat.chat.ui;

import edu.edx.yuri.androidchat.chat.entities.ChatMessage;

/**
 * Created by yuri_ on 10/11/2017.
 */

public interface ChatView {

    void sendMessage();
    void onMessageReceived(ChatMessage msg);

}
