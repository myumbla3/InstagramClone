package edu.citymail.instagramclone;

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
                .applicationId("VGSUvLqPcgk20bz0Fc6CMRYKptBgPBGLq6g6PR5I")
                .clientKey("lz33J5geGSq6oSEPHfae3cYyiGbpq8l5MAA2ZBxB")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
