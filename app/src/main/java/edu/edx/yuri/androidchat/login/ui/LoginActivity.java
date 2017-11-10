package edu.edx.yuri.androidchat.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.edx.yuri.androidchat.R;
import edu.edx.yuri.androidchat.contactList.ui.ContactListActivity;
import edu.edx.yuri.androidchat.login.LoginPresenter;
import edu.edx.yuri.androidchat.login.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.editTxtEmail)            EditText editTxtEmail;
    @BindView(R.id.editTxtPassword)         EditText editTxtPassword;
    @BindView(R.id.btnSignin)               Button btnSingnin;
    @BindView(R.id.btnSignup)               Button btnSignup;
    @BindView(R.id.progressBar)             ProgressBar progressBar;
    @BindView(R.id.layoutMainContainer)     RelativeLayout layoutMainContainer;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);//LoginRepositoryImpl ja foi instanciado com myUserReference igual a null ou apontando para aponta para o users/usercurrent@email_com
        loginPresenter.onCreate();//registrando loginPresenter no barramento de eventos
        loginPresenter.checkForAuthenticatedUser();






















        /*// Connect to the Firebase database
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Get a reference to the user child items it the database
        final DatabaseReference myRef = database.getReference("user");

        final DatabaseReference emailRef = myRef.child("email");

        emailRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                editTxtEmail.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG:", "Failed to read value.", databaseError.toException());
            }
        });

        btnSingnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEmail = editTxtEmail.getText().toString();
                emailRef.setValue(newEmail);
            }
        });*/

    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    @OnClick(R.id.btnSignup)
    public void handleSignUp(){
        loginPresenter.registerNewUser(editTxtEmail.getText().toString(),
                editTxtPassword.getText().toString());
    }

    @OnClick(R.id.btnSignin)
    public void handleSignIn() {
        loginPresenter.validateLogin(editTxtEmail.getText().toString(),
                editTxtPassword.getText().toString());
    }

    @Override
    public void navigateToMainScreen() {
        startActivity(new Intent(this, ContactListActivity.class));
    }

    @Override
    public void loginError(String error) {
        editTxtPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signin), error);
        editTxtPassword.setError(msgError);
    }

    @Override
    public void newUserSuccess() {
        Snackbar.make(layoutMainContainer, R.string.login_notice_message_useradded, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void newUserError(String error) {
        editTxtPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signup), error);
        editTxtPassword.setError(msgError);
    }


    @Override
    public void enableInputs() {
        setInputs(true);
    }

    @Override
    public void disableInputs() {
        setInputs(false);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    private void setInputs(boolean enabled){
        btnSignup.setEnabled(enabled);
        btnSingnin.setEnabled(enabled);
        editTxtEmail.setEnabled(enabled);
        editTxtPassword.setEnabled(enabled);
    }
}
