package com.example.imac.daggerdemo.simple.simple;

import com.example.imac.daggerdemo.base.IModel;
import com.example.imac.daggerdemo.base.IPersenter;
import com.example.imac.daggerdemo.base.IView;

/**
 * @author imac
 * @date 18/9/21
 */

public interface SimpleContract {

    interface View extends IView{}

    interface Model extends IModel{}

    interface Presenter extends IPersenter{}
}
