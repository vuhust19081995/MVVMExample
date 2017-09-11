package com.workspace.mvvmlogin.screen.login;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.Toast;
import com.workspace.mvvmlogin.data.model.User;
import com.workspace.mvvmlogin.data.source.AuthenicationDataSource;
import com.workspace.mvvmlogin.data.source.AuthenicationRepository;

/**
 * Created by workspace on 11/09/2017.
 */

public class LoginViewModel extends BaseObservable {
    private AuthenicationRepository mAuthenicationRepository;
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

    public View.OnClickListener onLoginClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuthenicationRepository.login(userName, password,
                        new AuthenicationDataSource.Callback<User>() {
                            @Override
                            public void onSuccess(User data) {
                                Toast.makeText(mContext, "Successful", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailed(String message) {
                                Toast.makeText(mContext, "Error!", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        };
    }
}
