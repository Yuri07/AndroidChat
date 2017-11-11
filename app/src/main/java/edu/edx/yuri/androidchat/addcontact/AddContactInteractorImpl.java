package edu.edx.yuri.androidchat.addcontact;

import edu.edx.yuri.androidchat.addcontact.ui.AddContactView;

/**
 * Created by yuri_ on 10/11/2017.
 */

public class AddContactInteractorImpl implements AddContactInteractor {
    AddContactRepositoryImpl addContactRepository;

    public AddContactInteractorImpl(AddContactRepositoryImpl addContactRepository) {
        this.addContactRepository = addContactRepository;
    }

    @Override
    public void addContact(String email) {
        addContactRepository.addContact(email);
    }
}
