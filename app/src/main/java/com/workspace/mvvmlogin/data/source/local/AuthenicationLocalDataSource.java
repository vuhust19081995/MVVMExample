package com.workspace.mvvmlogin.data.source.local;

import com.workspace.mvvmlogin.data.model.Admin;
import com.workspace.mvvmlogin.data.source.AuthenicationDataSource;
import java.util.Random;

/**
 * Created by workspace on 11/09/2017.
 */

public class AuthenicationLocalDataSource implements AuthenicationDataSource {

    public AuthenicationLocalDataSource() {
    }

    @Override
    public void login(String userName, String password, Callback<Admin> callback) {
        if(userName.equalsIgnoreCase("Nguyen Van Vu")&&password.equalsIgnoreCase("123456")){
            callback.onSuccess(new Admin(new Random().nextInt(),userName,password));
        }else{
            callback.onFailed("Error!");
        }
    }
}
