package com.example.imac.daggerdemo.simple.simple;

import com.example.imac.daggerdemo.base.BasePersenter;

/**
 * @author imac
 * @date 18/9/21
 */

public class SimplePresenter extends BasePersenter<SimpleContract.View,SimpleContract.Model> implements SimpleContract.Presenter{
    public SimplePresenter(SimpleContract.Model model, SimpleContract.View rootView) {
        super(model, rootView);
    }
}
