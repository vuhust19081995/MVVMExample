package com.workspace.mvvmlogin.screen.login;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.workspace.mvvmlogin.data.model.Admin;
import com.workspace.mvvmlogin.data.source.AuthenicationRepository;
import com.workspace.mvvmlogin.screen.main.MainActivity;

/**
 * Created by workspace on 11/09/2017.
 */

public class LoginViewModel extends BaseObservable implements LoginContract.ViewModel {
    private AuthenicationRepository mAuthenicationRepository;
    private LoginPresenter mLoginPresenter;
    private String userName;
    private String password;
    private Context mContext;

    public LoginViewModel(AuthenicationRepository mAuthenicationRepository, String userName,
            String password, Context mContext) {
        this.mAuthenicationRepository = mAuthenicationRepository;
        this.userName = userName;
        this.password = password;
        this.mContext = mContext;
    }

    public void setLoginPresenter(LoginPresenter loginPresenter){
        mLoginPresenter = loginPresenter;
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void onLoginClick() {
        mLoginPresenter.checkUser(userName,password);
    }

    @Override
    public void onSucess(Admin admin) {
        Toast.makeText(mContext, admin.getUserName(), Toast.LENGTH_SHORT).show();
        Intent mainActivity = new Intent(mContext, MainActivity.class);
        mContext.startActivity(mainActivity);
    }

    @Override
    public void onFailure(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
