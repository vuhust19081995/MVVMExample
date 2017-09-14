package com.workspace.mvvmlogin.data.source.remote;

import com.workspace.mvvmlogin.data.model.User;
import com.workspace.mvvmlogin.data.source.UserDataSource;
import com.workspace.mvvmlogin.data.source.remote.api.service.UserApi;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by workspace on 13/09/2017.
 */

public class UserRemoteDataSource extends BaseRemoteDataSource
        implements UserDataSource.RemoteDataSource {

    public UserRemoteDataSource(UserApi userApi) {
        super(userApi);
    }

    @Override
    public Observable<List<User>> getUsers() {
        return mUserApi.getUsers();
    }
}
