package edu.edx.yuri.androidchat.chat;

/**
 * Created by yuri_ on 10/11/2017.
 */

public interface ChatInteractor {

    void sendMessage(String msg);
    void setRecipient(String recipient);

    void destroyChatListener();
    void subscribeForChatUpates();
    void unSubscribeForChatUpates();

}
