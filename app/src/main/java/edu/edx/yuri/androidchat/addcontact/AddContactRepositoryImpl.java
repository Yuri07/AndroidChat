package edu.edx.yuri.androidchat.addcontact;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import edu.edx.yuri.androidchat.addcontact.AddContactEvent.AddContactEvent;
import edu.edx.yuri.androidchat.contactList.entities.User;
import edu.edx.yuri.androidchat.domain.FirebaseHelper;
import edu.edx.yuri.androidchat.lib.EventBus;
import edu.edx.yuri.androidchat.lib.GreenRobotEventBus;

/**
 * Created by yuri_ on 10/11/2017.
 */

public class AddContactRepositoryImpl implements AddContactRepository {
    @Override
    public void addContact(final String email) {
        final String key = email.replace(".","_");

        FirebaseHelper helper = FirebaseHelper.getInstance();
        final DatabaseReference userReference = helper.getUserReference(email);
        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                AddContactEvent event = new AddContactEvent();
                if (user != null) {
                    boolean online = user.isOnline();//recupera se o usuario que estou adcionando esta online
                    FirebaseHelper helper = FirebaseHelper.getInstance();

                    DatabaseReference userContactsReference = helper.getMyContactsReference();
                    userContactsReference.child(key).setValue(online);//adciona o contato no Database
                    // ja informando se esta online ou offline

                    String currentUserEmailKey = helper.getAuthUserEmail();
                    currentUserEmailKey = currentUserEmailKey.replace(".","_");
                    DatabaseReference reverseUserContactsReference = helper.getContactsReference(email);
                    reverseUserContactsReference.child(currentUserEmailKey).setValue(true);//adciona meu contato
                    // na lista de contatos do email que estou adcionando ja informando que estou online
                } else {
                    event.setError(true);
                }
                EventBus eventBus = GreenRobotEventBus.getInstance();
                eventBus.post(event);
            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {}
        });
    }
}
