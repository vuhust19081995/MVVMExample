package com.workspace.mvvmlogin.screen.main;

import android.view.View;
import com.workspace.mvvmlogin.data.model.User;
import com.workspace.mvvmlogin.screen.BaseRecyclerViewAdapter;
import java.util.Observable;

/**
 * Created by workspace on 13/09/2017.
 */

public class ItemUserViewModel extends Observable {
    private User mUser;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<User> mItemClickListener;

    public ItemUserViewModel(User user,
            BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<User> itemClickListener) {
        mUser = user;
        mItemClickListener = itemClickListener;
    }

    public String getUserLogin(){
        return mUser.getLogin();
    }

    public void onItemClicked(View view){
        if (mItemClickListener == null) {
            return;
        }
        mItemClickListener.onItemRecyclerViewClick(mUser);
    }
}
