package com.workspace.mvvmlogin.screen.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.workspace.mvvmlogin.BR;
import com.workspace.mvvmlogin.MainApplication;
import com.workspace.mvvmlogin.data.model.User;
import com.workspace.mvvmlogin.data.source.UserRepository;
import com.workspace.mvvmlogin.screen.BaseRecyclerViewAdapter;
import java.util.List;

/**
 * Created by workspace on 13/09/2017.
 */

public class MainViewModel extends BaseObservable
        implements BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<User>,
        MainContract.viewModel {
    private List<User> mUsers;
    private UserRepository mUserRepository;
    private UserAdapter mUserAdapter;
    private MainPresenter mMainPresenter;
    private boolean isComplete;

    public MainViewModel(UserRepository userRepository) {
        mUserRepository = userRepository;
    }

    public void setMainPresenter(MainPresenter mainPresenter) {
        mMainPresenter = mainPresenter;
        mainPresenter.getUsers();
        isComplete = false;
    }

    @Override
    public void onItemRecyclerViewClick(User data) {
        Toast.makeText(MainApplication.getContext(), data.getLogin(), Toast.LENGTH_SHORT).show();
    }

    @Bindable
    public UserAdapter getUserAdapter() {
        return mUserAdapter;
    }

    @Override
    public void onSuccess(List<User> users) {
        mUsers = users;
        mUserAdapter = new UserAdapter(mUsers);
        mUserAdapter.setItemClickListener(this);
        notifyPropertyChanged(BR.userAdapter);
        Toast.makeText(MainApplication.getContext(), users.size()+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(MainApplication.getContext(), msg, Toast.LENGTH_LONG).show();
        isComplete = true;
        notifyPropertyChanged(BR.complete);
    }

    @Override
    public void onShowProgress() {
        isComplete = false;
        notifyPropertyChanged(BR.complete);
    }

    @Override
    public void onHideProgress() {
        isComplete = true;
        notifyPropertyChanged(BR.complete);
    }

    @Bindable
    public boolean isComplete() {
        return isComplete;
    }


}
