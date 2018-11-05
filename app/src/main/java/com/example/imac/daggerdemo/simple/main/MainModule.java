package com.example.imac.daggerdemo.simple.main;

import dagger.Module;
import dagger.Provides;

/**
 * ================================================
 * 作   者：imac
 * 日   期：18/9/11
 * 描   述：
 * ================================================
 * @author imac
 */

@Module
public class MainModule {

    private MainContract.View view;

    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @Provides
    public MainContract.View provideView() {
        return view;
    }

    @Provides
    public MainContract.Model provideModel() {
        return new MainModel();
    }

    @Provides
    public MainContract.Persenter providerPersenter(MainContract.Model model, MainContract.View view) {
        return new MainPersenter(model, view);
    }
}
