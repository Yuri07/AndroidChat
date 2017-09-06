package edu.edx.yuri.androidchat.domain;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by yuri_ on 31/05/2017.
 */

public class FirebaseHelper {

    private final static String USERS_PATH = "users";

    private DatabaseReference dataReference;

    private static class SingletonHolder{
        private static final FirebaseHelper INSTANCE = new FirebaseHelper();
    }

    public static FirebaseHelper getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private FirebaseHelper(){
        dataReference = FirebaseDatabase.getInstance().getReference();
    }

    public DatabaseReference getDatareference(){
        return dataReference;
    }

    public DatabaseReference getMyUserReference(){
        return getUserReference(getAuthUserEmail());
    }

    public String getAuthUserEmail(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = null;
        if(user!=null)
            email = user.getEmail();

        return email;
    }

    public DatabaseReference getUserReference(String email){
        DatabaseReference userReference = null;
        if(email!=null){
            String emailKey = email.replace(".","_");
            userReference = dataReference.getRoot().child(USERS_PATH).child(emailKey);
        }
        return userReference;
    }

}
