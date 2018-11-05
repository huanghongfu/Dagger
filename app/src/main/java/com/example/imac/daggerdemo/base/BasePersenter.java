package com.example.imac.daggerdemo.base;

/**
 * ================================================
 * 作   者：imac
 * 日   期：18/9/11
 * 描   述：
 * ================================================
 */

public class BasePersenter<V extends IView, M extends IModel> implements IPersenter {


    protected M mModel;

    protected V mRootView;


    public BasePersenter(M model, V rootView) {
        mModel = model;
        mRootView = rootView;
    }

    @Override
    public void onAttach() {
    }

    @Override
    public void onDestroy() {
        mModel = null;
        mRootView = null;
    }
}
