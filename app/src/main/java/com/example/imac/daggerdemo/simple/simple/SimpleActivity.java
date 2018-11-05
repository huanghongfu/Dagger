package com.example.imac.daggerdemo.simple.simple;

import android.content.Context;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.util.Log;

import com.example.imac.daggerdemo.R;
import com.example.imac.daggerdemo.base.BaseActivity;
import com.example.imac.daggerdemo.component.AppComponent;
import com.example.imac.daggerdemo.module.ActivityScope;

/**
 * @author imac
 * @date 18/9/21
 */
@ActivityScope
public abstract class SimpleActivity extends BaseActivity<SimpleContract.Presenter, ViewDataBinding> implements SimpleContract.View {



    @Override
    protected void initProvider(AppComponent appComponent) {
        DaggerSimpleComponent.builder().appComponent(appComponent).simpleModule(new SimpleModule(this)).build().inject(this);
        Log.e(TAG, "mAppCode: " + mApp.hashCode());
        Log.e(TAG, "mManager: " + mManager.hashCode());
        Log.e(TAG, "mOkHttpClient: " + mOkHttpClient.hashCode());
        Log.e(TAG, "mRetrofit: " + mRetrofit.hashCode());
        Log.e(TAG, "mRetrofitBuilder: " + mRetrofitBuilder.hashCode());
        Log.e(TAG, "mBuilder: " + mBuilder.hashCode());
    }

}
