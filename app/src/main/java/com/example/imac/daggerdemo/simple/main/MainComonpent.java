package com.example.imac.daggerdemo.simple.main;

import com.example.imac.daggerdemo.component.AppComponent;
import com.example.imac.daggerdemo.module.ActivityScope;

import dagger.Component;

/**
 * ================================================
 * 作   者：imac
 * 日   期：18/9/11
 * 描   述：
 * ================================================
 */
@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComonpent {

    void inject(MainActivity activity);
}
