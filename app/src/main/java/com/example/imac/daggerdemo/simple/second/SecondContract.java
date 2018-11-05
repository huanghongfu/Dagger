package com.example.imac.daggerdemo.simple.second;

import com.example.imac.daggerdemo.base.IModel;
import com.example.imac.daggerdemo.base.IPersenter;
import com.example.imac.daggerdemo.base.IView;

/**
 * @author imac
 * @date 18/9/21
 */

public interface SecondContract {
    interface View extends IView {
        void onSuccess();

        void onError();
    }

    interface Model extends IModel {
        void getPersonList();
    }

    interface Presenter extends IPersenter {
        void getPersonList();
    }
}
