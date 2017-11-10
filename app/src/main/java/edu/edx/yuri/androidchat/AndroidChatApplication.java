package edu.edx.yuri.androidchat;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

import edu.edx.yuri.androidchat.lib.GlideImageLoader;
import edu.edx.yuri.androidchat.lib.ImageLoader;

/**
 * Created by yuri_ on 29/05/2017.
 */

public class AndroidChatApplication extends Application {
    private ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();
        setupImageLoader();
    }

    private void setupImageLoader() {
        imageLoader = new GlideImageLoader(this);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    private void setupFirebase(){
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

}
