package edu.edx.yuri.androidchat.login;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import edu.edx.yuri.androidchat.contactList.entities.User;
import edu.edx.yuri.androidchat.domain.FirebaseHelper;

/**
 * Created by yuri_ on 31/05/2017.
 */

public class LoginRepositoryImpl implements LoginRepository {
    private FirebaseHelper helper;
    private DatabaseReference dataReference;
    private DatabaseReference myUserReference;

    public LoginRepositoryImpl(){
        helper = FirebaseHelper.getInstance();
        dataReference = helper.getDatareference();
        myUserReference = helper.getMyUserReference();
    }

    @Override
    public void checkAlreadyAuthenticated() {
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            myUserReference = helper.getMyUserReference();
            myUserReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    initSingIn(dataSnapshot);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    private void initSingIn(DataSnapshot snapshot){
        User currentUser = snapshot.getValue(User.class);
        if (currentUser == null) {
            registerNewUser();
        }
    }

    private void registerNewUser() {
        String email = helper.getAuthUserEmail();
        if (email != null) {
            User currentUser = new User(email, true, null);
            myUserReference.setValue(currentUser);
        }
    }

}
