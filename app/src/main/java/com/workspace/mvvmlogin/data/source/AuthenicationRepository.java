package com.workspace.mvvmlogin.data.source;

import io.reactivex.Observable;

/**
 * Created by workspace on 11/09/2017.
 */

public class AuthenicationRepository implements AuthenicationDataSource {
    private AuthenicationDataSource mLocalDataSource;

    public AuthenicationRepository(AuthenicationDataSource localDataSource) {
        mLocalDataSource = localDataSource;
    }

    @Override
    public Observable<Boolean> login(String userName, String password) {
        return mLocalDataSource.login(userName,password);
    }
}
