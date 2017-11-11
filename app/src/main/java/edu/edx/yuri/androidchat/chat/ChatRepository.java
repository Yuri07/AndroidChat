package edu.edx.yuri.androidchat.chat;

/**
 * Created by yuri_ on 10/11/2017.
 */

public interface ChatRepository {

    void sendMessage(String msg);
    void setReceiver(String receiver);

    void destroyChatListener();
    void subscribeForChatUpates();
    void unSubscribeForChatUpates();

    void changeUserConnectionStatus(boolean online);

}
