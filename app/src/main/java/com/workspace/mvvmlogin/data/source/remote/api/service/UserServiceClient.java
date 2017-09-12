package com.workspace.mvvmlogin.data.source.remote.api.service;

import android.app.Application;
import com.workspace.mvvmlogin.utils.Constant;

/**
 * Created by workspace on 13/09/2017.
 */

public class UserServiceClient extends ServiceClient {
    private static UserApi mUserApiInstance;
    public static void initialize(Application application){
        mUserApiInstance = createService(application, Constant.END_POINT_URL,UserApi.class);
    }
    public static UserApi getInstance(){
        if (mUserApiInstance == null) {
            throw new RuntimeException("Need call method NameServiceClient#initialize() first");
        }
        return mUserApiInstance;
    }
}
