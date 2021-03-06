package edu.edx.yuri.androidchat.contactList;

/**
 * Created by yuri_ on 10/11/2017.
 */

public class ContactListInteractorImpl implements ContactListInteractor {

    //ContactListRepositoryImpl contactListRepository;
    ContactListRepository contactListRepository;//essa substituicao ainda nao foi testada(31/01/2018)

    public ContactListInteractorImpl() {
        this.contactListRepository = new ContactListRepositoryImpl();
    }

    @Override
    public void subscribeForContactEvents() {
        contactListRepository.subscribeForContactListUpdates();
    }

    @Override
    public void unSubscribeForContactEvents() {
        contactListRepository.unSubscribeForContactListUpdates();
    }

    @Override
    public void destroyContactListListener() {
        contactListRepository.destroyContactListListener();
    }

    @Override
    public void removeContact(String email) {
        contactListRepository.removeContact(email);
    }
}
