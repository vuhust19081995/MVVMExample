package com.workspace.mvvmlogin.screen.main;

import com.workspace.mvvmlogin.data.model.User;
import com.workspace.mvvmlogin.screen.BaseRecyclerViewAdapter;
import java.util.Observable;

/**
 * Created by workspace on 13/09/2017.
 */

public class MainViewModel extends Observable implements
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<User> {
    private UserAdapter mUserAdapter;

    public MainViewModel(UserAdapter userAdapter) {
        mUserAdapter = userAdapter;
        userAdapter.setItemClickListener(this);
    }

    @Override
    public void onItemRecyclerViewClick(User item) {

    }

    public UserAdapter getAdapter() {
        return mUserAdapter;
    }
}
