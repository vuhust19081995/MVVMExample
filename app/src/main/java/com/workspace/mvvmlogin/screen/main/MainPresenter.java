package com.workspace.mvvmlogin.screen.main;

import com.workspace.mvvmlogin.data.model.User;
import com.workspace.mvvmlogin.data.source.UserRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * Created by workspace on 14/09/2017.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.viewModel mViewModel;
    private UserRepository mUserRepository;
    private CompositeDisposable mCompositeDisposable;

    public MainPresenter(MainContract.viewModel viewModel, UserRepository userRepository) {
        mViewModel = viewModel;
        mUserRepository = userRepository;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getUsers() {
        mViewModel.onShowProgress();
        mCompositeDisposable.add(mUserRepository.getUsers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<User>>() {

                    @Override
                    public void onNext(List<User> value) {
                        mViewModel.onSuccess(value);
                        mViewModel.onHideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onError(e.getMessage());
                        mViewModel.onHideProgress();
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}
