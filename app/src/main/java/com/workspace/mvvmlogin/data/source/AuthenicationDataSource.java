package com.workspace.mvvmlogin.data.source;

import io.reactivex.Observable;

/**
 * Created by workspace on 11/09/2017.
 */

public interface AuthenicationDataSource {

    Observable<Boolean> login(String userName,String password);
}
