package com.workspace.mvvmlogin.screen.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.workspace.mvvmlogin.R;
import com.workspace.mvvmlogin.data.source.AuthenicationRepository;
import com.workspace.mvvmlogin.data.source.local.AuthenicationLocalDataSource;
import com.workspace.mvvmlogin.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel mLoginViewModel;
    private AuthenicationRepository mAuthenicationRepository;
    private ActivityLoginBinding mActivityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        mAuthenicationRepository = new AuthenicationRepository(new AuthenicationLocalDataSource());
        String userName = mActivityLoginBinding.edtUserName.getText().toString();
        String password = mActivityLoginBinding.edtPassword.getText().toString();
        mLoginViewModel = new LoginViewModel(mAuthenicationRepository,userName,password,this);
        mActivityLoginBinding.setViewModel(mLoginViewModel);
    }
}
