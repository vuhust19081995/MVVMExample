package com.workspace.mvvmlogin;

import android.app.Application;
import android.content.Context;
import com.workspace.mvvmlogin.data.source.remote.api.service.UserServiceClient;

/**
 * Created by workspace on 13/09/2017.
 */

public class MainApplication extends Application {

    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        UserServiceClient.initialize(this);
    }
}
