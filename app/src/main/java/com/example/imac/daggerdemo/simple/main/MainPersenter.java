package com.example.imac.daggerdemo.simple.main;

import android.util.Log;

import com.example.imac.daggerdemo.base.BasePersenter;

import javax.inject.Inject;

/**
 * ================================================
 * 作   者：imac
 * 日   期：18/9/11
 * 描   述：
 * ================================================
 */

public class MainPersenter extends BasePersenter<MainContract.View, MainContract.Model> implements MainContract.Persenter {
    private static final String TAG = "MainPersenter";

    public MainPersenter(MainContract.Model model, MainContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void getPersonList() {
        mModel.getPersonList();
        Log.e(TAG, "mModel=" + mModel.getClass().getSimpleName());
        Log.e(TAG, "mRootView=" + mRootView.getClass().getSimpleName());
    }
}
