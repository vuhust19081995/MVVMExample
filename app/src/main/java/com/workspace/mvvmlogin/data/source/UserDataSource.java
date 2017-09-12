package com.workspace.mvvmlogin.data.source;

import com.workspace.mvvmlogin.data.model.User;
import com.workspace.mvvmlogin.data.source.remote.api.service.UserApi;
import java.util.List;

/**
 * Created by workspace on 13/09/2017.
 */

public interface UserDataSource {

    interface Callback<T> {
        void onSuccess(T data);

        void onFailure(String msg);
    }

    interface RemoteDataSource {
        void getUsers(UserApi userApi,Callback<List<User>> callback);
    }
}
