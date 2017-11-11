package edu.edx.yuri.androidchat.chat;

import edu.edx.yuri.androidchat.chat.ChatInteractor;

/**
 * Created by yuri_ on 10/11/2017.
 */

public class ChatInteractorImpl implements ChatInteractor {

    ChatRepository chatRepository;

    public ChatInteractorImpl() {
        this.chatRepository = new ChatRepositoryImpl();
    }

    @Override
    public void subscribeForChatUpates() {
        chatRepository.subscribeForChatUpates();
    }

    @Override
    public void unSubscribeForChatUpates() {
        chatRepository.unSubscribeForChatUpates();
    }

    @Override
    public void destroyChatListener() {
        chatRepository.destroyChatListener();
    }

    @Override
    public void setRecipient(String recipient) {
        chatRepository.setReceiver(recipient);
    }

    @Override
    public void sendMessage(String msg) {
        chatRepository.sendMessage(msg);
    }
}
