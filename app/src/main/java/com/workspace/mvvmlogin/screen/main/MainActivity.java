package com.workspace.mvvmlogin.screen.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.workspace.mvvmlogin.R;
import com.workspace.mvvmlogin.data.source.UserRepository;
import com.workspace.mvvmlogin.data.source.remote.UserRemoteDataSource;
import com.workspace.mvvmlogin.data.source.remote.api.service.UserServiceClient;
import com.workspace.mvvmlogin.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private MainPresenter mMainPresenter;
    private UserRepository mUserRepository;
    private MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserRepository = new UserRepository(new UserRemoteDataSource(UserServiceClient.getInstance()));
        mainViewModel = new MainViewModel(mUserRepository);
        mMainPresenter = new MainPresenter(mainViewModel,mUserRepository);
        mainViewModel.setMainPresenter(mMainPresenter);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setViewModel(mainViewModel);
    }
}
