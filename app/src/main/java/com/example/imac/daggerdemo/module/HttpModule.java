package com.example.imac.daggerdemo.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * ================================================
 * 作   者：imac
 * 日   期：18/9/11
 * 描   述：
 * ================================================
 */

@Module
public class HttpModule {

    @Singleton
    @Provides
    public OkHttpClient.Builder provideClientBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    public Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Provides
    @Singleton
    public OkHttpClient provideClient(OkHttpClient.Builder builder) {
        return builder.build();
    }


    @Singleton
    @Provides
    public Retrofit provideRetrofit(Retrofit.Builder builder) {
        return builder.build();
    }

}
