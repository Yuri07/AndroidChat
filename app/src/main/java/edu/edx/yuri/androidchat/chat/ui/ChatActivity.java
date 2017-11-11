package edu.edx.yuri.androidchat.chat.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.edx.yuri.androidchat.R;

public class ChatActivity extends AppCompatActivity {

    public final static String EMAIL_KEY = "email";
    public final static String ONLINE_KEY = "online";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }
}
