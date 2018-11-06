package com.example.imac.daggerdemo.simple;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.example.imac.daggerdemo.component.AppComponent;
import com.example.imac.daggerdemo.component.DaggerAppComponent;
import com.example.imac.daggerdemo.module.AppDelModule;
import com.example.imac.daggerdemo.module.HttpModule;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * ================================================
 * 作   者：imac
 * 日   期：18/9/12
 * 描   述：
 * ================================================
 */

public class App extends Application {

    private AppComponent mAppComponent;

    private static App mApp;

    @Inject
    AppConfig mAppConfig;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        Utils.init(this);
        mAppComponent = DaggerAppComponent
                .builder()
                .appDelModule(new AppDelModule(this))
                .httpModule(new HttpModule())
                .build();
        mAppComponent.inject(this);

        mAppConfig
                .setConfigClient(new AppConfig.ConfigClient() {
                    @Override
                    public OkHttpClient.Builder config(OkHttpClient.Builder builder) {
                        return builder;
                    }
                })
                .setConfigRetrofit(new AppConfig.ConfigRetrofit() {
                    @Override
                    public Retrofit.Builder config(Retrofit.Builder builder) {
                        builder.baseUrl("https://www.baidu.com/");
                        return builder;
                    }
                })
                .build();
    }


    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static App getApp() {
        return mApp;
    }

}
