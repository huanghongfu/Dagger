package com.example.imac.daggerdemo.component;

import com.example.imac.daggerdemo.manager.RepositoryManager;
import com.example.imac.daggerdemo.module.AppDelModule;
import com.example.imac.daggerdemo.module.HttpModule;
import com.example.imac.daggerdemo.simple.App;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * ================================================
 * 作   者：imac
 * 日   期：18/9/12
 * 描   述：
 * ================================================
 */
@Singleton
@Component(modules = {HttpModule.class, AppDelModule.class})
public interface AppComponent {

    App getApp();

    OkHttpClient getClient();

    Retrofit getRetrofit();

    OkHttpClient.Builder getOBuilder();

    Retrofit.Builder getRBudiler();

    RepositoryManager getManager();

    void inject(App app);


}
