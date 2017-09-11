package com.workspace.mvvmlogin.data.source;

import com.workspace.mvvmlogin.data.model.User;

/**
 * Created by workspace on 11/09/2017.
 */

public class AuthenicationRepository implements AuthenicationDataSource {
    private AuthenicationDataSource mLocalDataSource;

    public AuthenicationRepository(AuthenicationDataSource localDataSource) {
        mLocalDataSource = localDataSource;
    }

    @Override
    public void login(String userName, String password, Callback<User> callback) {
        mLocalDataSource.login(userName,password,callback);
    }
}
