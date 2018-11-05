package com.example.imac.daggerdemo.simple.second;

import com.example.imac.daggerdemo.base.BasePersenter;

/**
 * @author imac
 * @date 18/9/21
 */

public class SecondPersenter extends BasePersenter<SecondContract.View, SecondContract.Model> implements SecondContract.Presenter {
    public SecondPersenter(SecondContract.Model model, SecondContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void getPersonList() {

    }
}
