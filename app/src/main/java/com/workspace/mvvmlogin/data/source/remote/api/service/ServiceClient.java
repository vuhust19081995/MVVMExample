package com.workspace.mvvmlogin.data.source.remote.api.service;

import android.app.Application;
import android.support.annotation.NonNull;
import com.google.gson.Gson;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by workspace on 13/09/2017.
 */

public class ServiceClient {
    static <T> T createService(Application application, String endPoint, Class<T> serviceClass) {
        return createService(application, endPoint, serviceClass,null);
    }

    static <T> T createService(Application application, String endPoint, Class<T> serviceClass,
            @NonNull Gson gson) {
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }
}
