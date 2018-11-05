package com.example.imac.daggerdemo.module;

import com.example.imac.daggerdemo.manager.RepositoryManager;
import com.example.imac.daggerdemo.simple.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * ================================================
 * 作   者：imac
 * 日   期：18/9/12
 * 描   述：
 * ================================================
 */
@Module
public class AppDelModule {

    private App mApplication;

    public AppDelModule(App application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    public App provideApp() {
        return mApplication;
    }

    @Provides
    @Singleton
    public RepositoryManager provideManager() {
        return new RepositoryManager();
    }

}