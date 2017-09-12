package com.workspace.mvvmlogin;

import android.app.Application;
import com.workspace.mvvmlogin.data.source.remote.api.service.UserServiceClient;

/**
 * Created by workspace on 13/09/2017.
 */

public class MainApplication extends Application {
    private static final int REALM_SCHEMA_VERSION = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        UserServiceClient.initialize(this);
    }
}
