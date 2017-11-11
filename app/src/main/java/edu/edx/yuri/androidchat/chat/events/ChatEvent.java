package edu.edx.yuri.androidchat.chat.events;

import edu.edx.yuri.androidchat.chat.entities.ChatMessage;

/**
 * Created by yuri_ on 10/11/2017.
 */

public class ChatEvent {

    ChatMessage msg;

    public ChatEvent(ChatMessage msg) {
        this.msg = msg;
    }

    public ChatMessage getMessage() {
        return msg;
    }

}
