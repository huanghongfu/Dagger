package com.example.imac.daggerdemo.manager;

import android.util.Log;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * ================================================
 * 作   者：imac
 * 日   期：18/9/12
 * 描   述：仓库管理
 * ================================================
 */

public class RepositoryManager {
    private static final String TAG = "RepositoryManager";
    @Inject
    Retrofit mRetrofit;

    public RepositoryManager() {
    }

    public <C> C obtainRetrofit(Class<C> clz) {
        return mRetrofit.create(clz);
    }
}
