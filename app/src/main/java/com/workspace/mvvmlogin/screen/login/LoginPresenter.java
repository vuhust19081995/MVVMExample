package com.workspace.mvvmlogin.screen.login;

import com.workspace.mvvmlogin.data.model.Admin;
import com.workspace.mvvmlogin.data.source.AuthenicationRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.Random;

/**
 * Created by workspace on 14/09/2017.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.ViewModel mViewModel;
    private AuthenicationRepository mAuthenicationRepository;
    private CompositeDisposable mCompositeDisposable;

    public LoginPresenter(LoginContract.ViewModel viewModel,
            AuthenicationRepository authenicationRepository) {
        mViewModel = viewModel;
        mAuthenicationRepository = authenicationRepository;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void checkUser(final String userName, final String password) {
        mCompositeDisposable.add(mAuthenicationRepository.login(userName,password)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Boolean>() {

                    @Override
                    public void onNext(Boolean check) {
                       if(check){
                           mViewModel.onSucess(new Admin(new Random().nextInt(),userName,password));
                       }else{
                           mViewModel.onFailure("Error");
                       }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}
