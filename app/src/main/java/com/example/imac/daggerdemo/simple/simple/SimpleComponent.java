package com.example.imac.daggerdemo.simple.simple;

import com.example.imac.daggerdemo.base.BaseActivity;
import com.example.imac.daggerdemo.component.AppComponent;
import com.example.imac.daggerdemo.module.ActivityScope;

import dagger.Component;

/**
 * @author imac
 * @date 18/9/21
 */
@ActivityScope
@Component(modules = SimpleModule.class,dependencies = AppComponent.class)
public interface SimpleComponent {

    void inject(SimpleActivity activity);
}
