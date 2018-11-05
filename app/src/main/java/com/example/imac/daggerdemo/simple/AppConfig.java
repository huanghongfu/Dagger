package com.example.imac.daggerdemo.simple;

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

public class AppConfig {

    private ConfigClient mConfigClient;
    private ConfigRetrofit mConfigRetrofit;

    public OkHttpClient.Builder mOkHttpBuilder;

    public Retrofit.Builder mRetrofitBuilder;

    @Inject
    public AppConfig(OkHttpClient.Builder okHttpBuilder, Retrofit.Builder retrofitBuilder) {
        mOkHttpBuilder = okHttpBuilder;
        mRetrofitBuilder = retrofitBuilder;
    }

    public AppConfig setConfigClient(ConfigClient configClient) {
        mConfigClient = configClient;
        return this;
    }

    public AppConfig setConfigRetrofit(ConfigRetrofit configRetrofit) {
        mConfigRetrofit = configRetrofit;
        return this;
    }


    public void build() {
        if (mConfigClient != null) {
            mOkHttpBuilder = mConfigClient.config(mOkHttpBuilder);
        }
        if (mConfigRetrofit != null) {
            mRetrofitBuilder = mConfigRetrofit.config(mRetrofitBuilder);
        }

        mRetrofitBuilder.client(mOkHttpBuilder.build());
    }


    public interface ConfigClient {
        OkHttpClient.Builder config(OkHttpClient.Builder builder);
    }

    public interface ConfigRetrofit {
        Retrofit.Builder config(Retrofit.Builder builder);
    }
}
