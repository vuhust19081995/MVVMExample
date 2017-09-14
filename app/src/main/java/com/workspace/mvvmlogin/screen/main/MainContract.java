package com.workspace.mvvmlogin.screen.main;

import com.workspace.mvvmlogin.data.model.User;
import java.util.List;

/**
 * Created by workspace on 14/09/2017.
 */

public class MainContract {
    interface Presenter{
        void getUsers();
    }

    interface viewModel{
        void onSuccess(List<User> users);

        void onError(String msg);

        void onShowProgress();

        void onHideProgress();
    }
}
