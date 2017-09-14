package com.workspace.mvvmlogin.data.source;

import com.workspace.mvvmlogin.data.model.User;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by workspace on 13/09/2017.
 */

public interface UserDataSource {

    interface RemoteDataSource {
        Observable<List<User>> getUsers();
    }
}
