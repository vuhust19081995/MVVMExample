package com.workspace.mvvmlogin.data.source;

import com.workspace.mvvmlogin.data.model.User;
import com.workspace.mvvmlogin.data.source.remote.UserRemoteDataSource;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by workspace on 13/09/2017.
 */

public class UserRepository implements UserDataSource.RemoteDataSource {
    private UserRemoteDataSource mUserRemoteDataSource;

    public UserRepository(UserRemoteDataSource userRemoteDataSource) {
        mUserRemoteDataSource = userRemoteDataSource;
    }

    @Override
    public Observable<List<User>> getUsers() {
        return mUserRemoteDataSource.getUsers();
    }
}
