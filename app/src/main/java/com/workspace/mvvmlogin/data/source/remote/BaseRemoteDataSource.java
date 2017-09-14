package com.workspace.mvvmlogin.data.source.remote;

import com.workspace.mvvmlogin.data.source.remote.api.service.UserApi;

/**
 * Created by workspace on 13/09/2017.
 */

public abstract class BaseRemoteDataSource {
    UserApi mUserApi;

    public BaseRemoteDataSource(UserApi userApi) {
        mUserApi = userApi;
    }
}
