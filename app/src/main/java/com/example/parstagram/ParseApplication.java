package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("hK41eqOY29fkvuiXzuJGvHuEbch0ioYN1ricHmD1")
                .clientKey("VtQtmWY7LDfl86TkvqaPaJHBVpULM248U8wjy3xW")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
