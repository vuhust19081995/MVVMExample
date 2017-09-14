package com.workspace.mvvmlogin.screen.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import com.workspace.mvvmlogin.data.model.User;
import com.workspace.mvvmlogin.screen.BaseRecyclerViewAdapter;

/**
 * Created by workspace on 13/09/2017.
 */

public class ItemUserViewModel extends BaseObservable{
    private User mUser;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<User> mItemClickListener;

    public ItemUserViewModel(User user,
            BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<User> itemClickListener) {
        mUser = user;
        mItemClickListener = itemClickListener;
    }

    @Bindable
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
