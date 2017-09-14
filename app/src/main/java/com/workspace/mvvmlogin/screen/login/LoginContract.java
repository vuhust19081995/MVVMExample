package com.workspace.mvvmlogin.screen.login;

import com.workspace.mvvmlogin.data.model.Admin;

/**
 * Created by workspace on 14/09/2017.
 */

public interface LoginContract {
    interface Presenter{
        void checkUser(String userName,String password);
    }

    interface ViewModel{
        void onSucess(Admin admin);

        void onFailure(String msg);
    }
}
