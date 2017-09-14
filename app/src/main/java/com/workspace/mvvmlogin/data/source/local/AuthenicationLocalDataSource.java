package com.workspace.mvvmlogin.data.source.local;

import com.workspace.mvvmlogin.data.source.AuthenicationDataSource;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by workspace on 11/09/2017.
 */

public class AuthenicationLocalDataSource implements AuthenicationDataSource {

    public AuthenicationLocalDataSource() {
    }

    @Override
    public Observable<Boolean> login(String userName, String password) {
        if(userName.equals("Nguyen Van Vu")&&password.equals("123456")){
            return Observable.create(new ObservableOnSubscribe<Boolean>() {
                @Override
                public void subscribe(ObservableEmitter<Boolean> e) throws Exception {
                    e.onNext(true);
                }
            });
        }else{
            return Observable.create(new ObservableOnSubscribe<Boolean>() {
                @Override
                public void subscribe(ObservableEmitter<Boolean> e) throws Exception {
                    e.onNext(false);
                }
            });
        }
    }
}
