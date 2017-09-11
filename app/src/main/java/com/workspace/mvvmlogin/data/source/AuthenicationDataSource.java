package com.workspace.mvvmlogin.data.source;

import com.workspace.mvvmlogin.data.model.User;

/**
 * Created by workspace on 11/09/2017.
 */

public interface AuthenicationDataSource {

    interface Callback<T>{
        void onSuccess(T data);
        void onFailed(String message);
    }

    void login(String userName,String password,Callback<User> callback);
}
