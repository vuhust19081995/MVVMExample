package com.workspace.mvvmlogin.data.source;

import com.workspace.mvvmlogin.data.model.User;
import com.workspace.mvvmlogin.data.source.remote.api.service.UserApi;
import java.util.List;

/**
 * Created by workspace on 13/09/2017.
 */

public class UserRepository implements UserDataSource.RemoteDataSource {
    private UserDataSource.RemoteDataSource mRemoteDataSource;

    public UserRepository(UserDataSource.RemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public void getUsers(UserApi userApi, UserDataSource.Callback<List<User>> callback) {
        mRemoteDataSource.getUsers(userApi,callback);
    }
}
