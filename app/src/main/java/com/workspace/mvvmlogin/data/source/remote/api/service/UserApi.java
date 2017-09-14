package com.workspace.mvvmlogin.data.source.remote.api.service;

import com.workspace.mvvmlogin.data.model.User;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;

/**
 * Created by workspace on 13/09/2017.
 */

public interface UserApi {
    @GET("/users/follower/followers")
    Observable<List<User>> getUsers();
}
