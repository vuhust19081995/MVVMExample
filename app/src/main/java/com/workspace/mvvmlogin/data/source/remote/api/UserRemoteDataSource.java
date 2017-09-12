package com.workspace.mvvmlogin.data.source.remote.api;

import com.workspace.mvvmlogin.data.model.User;
import com.workspace.mvvmlogin.data.source.UserDataSource;
import com.workspace.mvvmlogin.data.source.remote.api.service.UserApi;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by workspace on 13/09/2017.
 */

public class UserRemoteDataSource implements
        UserDataSource.RemoteDataSource {

    public UserRemoteDataSource() {

    }

    @Override
    public void getUsers(UserApi userApi, final UserDataSource.Callback<List<User>> callback) {
        userApi.getUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                List<User> mUserList = new ArrayList<User>();
                if(response.isSuccessful()){
                    mUserList = response.body();
                }else{
                    int statusCode = response.code();
                }
                callback.onSuccess(mUserList);
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                callback.onFailure("get api error!");
            }
        });
    }
}
