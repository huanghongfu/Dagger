package com.example.imac.daggerdemo.base;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.imac.daggerdemo.component.AppComponent;
import com.example.imac.daggerdemo.manager.RepositoryManager;
import com.example.imac.daggerdemo.module.ActivityScope;
import com.example.imac.daggerdemo.simple.App;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * ================================================
 * 作   者：imac
 * 日   期：18/9/11
 * 描   述：
 * ================================================
 */

public abstract class BaseActivity<P extends IPersenter, V extends ViewDataBinding> extends Activity implements IView {
    protected static final String TAG = "BaseActivity";

    @Inject
    protected P mPersenter;

    protected V mBinding;

    @Inject
    protected App mApp;

    @Inject
    protected RepositoryManager mManager;

    @Inject
    protected OkHttpClient mOkHttpClient;

    @Inject
    protected Retrofit mRetrofit;

    @Inject
    protected Retrofit.Builder mRetrofitBuilder;

    @Inject
    protected OkHttpClient.Builder mBuilder;

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes());
        mContext = this;
        initProvider(App.getApp().getAppComponent());
        initDatas();
        initListeners();
    }

    protected abstract int getLayoutRes();

    protected abstract void initProvider(AppComponent appComponent);

    protected abstract void initDatas();

    protected abstract void initListeners();

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    protected void onDestroy() {
        mPersenter.onDestroy();
        super.onDestroy();
    }
}
