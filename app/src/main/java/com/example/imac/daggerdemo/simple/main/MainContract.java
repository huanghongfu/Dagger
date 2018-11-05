package com.example.imac.daggerdemo.simple.main;

import com.example.imac.daggerdemo.base.IModel;
import com.example.imac.daggerdemo.base.IPersenter;
import com.example.imac.daggerdemo.base.IView;

/**
 * ================================================
 * 作   者：imac
 * 日   期：18/9/11
 * 描   述：
 * ================================================
 */

public interface MainContract {

    interface View extends IView {
        void onSuccess();

        void onError();
    }

    interface Model extends IModel {
        void getPersonList();
    }

    interface Persenter extends IPersenter {
        void getPersonList();
    }

}
