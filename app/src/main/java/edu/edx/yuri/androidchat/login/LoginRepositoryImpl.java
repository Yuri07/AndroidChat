package edu.edx.yuri.androidchat.login;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import edu.edx.yuri.androidchat.contactList.entities.User;
import edu.edx.yuri.androidchat.domain.FirebaseHelper;
import edu.edx.yuri.androidchat.lib.EventBus;
import edu.edx.yuri.androidchat.lib.GreenRobotEventBus;
import edu.edx.yuri.androidchat.login.events.LoginEvent;

/**
 * Created by yuri_ on 31/05/2017.
 *
 * All implementation related to the firebase
 * will be under the login repository implementation
 *
 */

public class LoginRepositoryImpl implements LoginRepository {
    private FirebaseHelper helper;
    private DatabaseReference dataReference;
    private DatabaseReference myUserReference;

    public LoginRepositoryImpl(){
        helper = FirebaseHelper.getInstance();
        dataReference = helper.getDatareference();
        myUserReference = helper.getMyUserReference();//aponta para o users/usercurrent@email_com
    }

    @Override
    public void signUp(final String email, final String password) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        postEvent(LoginEvent.onSignUpSuccess);//somente mostra mensagem que deu certo o signup
                        signIn(email, password);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        postEvent(LoginEvent.onSignUpError, e.getMessage());
                    }
                });
    }

    @Override
    public void signIn(String email, String password) {
        try {
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            myUserReference = helper.getMyUserReference();//pega a referencia no
                            // database para o usuario atualmente autenticado, caso seja a primeira
                            //vez sera criada a referencia sem os campos email, online e contacts
                            myUserReference.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot snapshot) {
                                    initSignIn(snapshot);//grava new User(currentUserEmail, true, null); no database users/currentUserEmail/
                                }
                                @Override
                                public void onCancelled(DatabaseError firebaseError) {
                                    postEvent(LoginEvent.onSignInError, firebaseError.getMessage());
                                }
                            });
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            postEvent(LoginEvent.onSignInError, e.getMessage());
                        }
                    });
        } catch (Exception e) {
            postEvent(LoginEvent.onSignInError, e.getMessage());
        }
    }

    @Override
    public void checkAlreadyAuthenticated() {
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            myUserReference = helper.getMyUserReference();
            myUserReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    initSignIn(dataSnapshot);
                }

                @Override
                public void onCancelled(DatabaseError firebaseError) {
                    postEvent(LoginEvent.onSignInError, firebaseError.getMessage());
                }
            });
        }else {
            postEvent(LoginEvent.onFailedToRecoverSession);
        }
    }

    private void initSignIn(DataSnapshot snapshot){
        User currentUser = snapshot.getValue(User.class);
        if (currentUser == null) {
            registerNewUser();
        }
        helper.changeUserConnectionStatus(User.ONLINE);
        postEvent(LoginEvent.onSignInSuccess);
    }

    private void registerNewUser() {
        String email = helper.getAuthUserEmail();
        if (email != null) {
            User currentUser = new User(email, true, null);
            myUserReference.setValue(currentUser);
        }
    }

    private void postEvent(int type) {
        postEvent(type, null);
    }

    private void postEvent(int type, String errorMessage) {
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setEventType(type);
        if (errorMessage != null) {
            loginEvent.setErrorMesage(errorMessage);
        }

        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(loginEvent);
    }

}
