package com.example.imac.daggerdemo.simple.second;

import com.example.imac.daggerdemo.component.AppComponent;
import com.example.imac.daggerdemo.module.ActivityScope;
import com.example.imac.daggerdemo.simple.main.MainModule;

import dagger.Component;

/**
 * @author imac
 * @date 18/9/21
 */

@ActivityScope
@Component(modules = SecondModule.class, dependencies = AppComponent.class)
public interface SecondComponent {

    void inject(SecondActivity activity);
}
