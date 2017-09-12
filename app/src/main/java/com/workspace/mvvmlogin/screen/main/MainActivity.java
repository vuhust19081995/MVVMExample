package com.workspace.mvvmlogin.screen.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.workspace.mvvmlogin.R;
import com.workspace.mvvmlogin.data.model.User;
import com.workspace.mvvmlogin.data.source.UserDataSource;
import com.workspace.mvvmlogin.data.source.UserRepository;
import com.workspace.mvvmlogin.data.source.remote.api.UserRemoteDataSource;
import com.workspace.mvvmlogin.data.source.remote.api.service.UserServiceClient;
import com.workspace.mvvmlogin.databinding.ActivityMainBinding;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mMainViewModel;
    private UserRepository mUserRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserRepository =
                new UserRepository(new UserRemoteDataSource());
        mUserRepository.getUsers(UserServiceClient.getInstance(), new
                UserDataSource.Callback<List<User>>() {
                    @Override
                    public void onSuccess(List<User> data) {
                        UserAdapter userAdapter =  new UserAdapter(data,MainActivity.this);
                        mMainViewModel = new MainViewModel(userAdapter);
                        ActivityMainBinding binding = DataBindingUtil
                                .setContentView(MainActivity.this,R.layout.activity_main);
                        binding.setViewModel(mMainViewModel);
                    }

                    @Override
                    public void onFailure(String msg) {
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
