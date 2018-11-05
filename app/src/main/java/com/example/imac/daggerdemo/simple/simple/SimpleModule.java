package com.example.imac.daggerdemo.simple.simple;

import dagger.Module;
import dagger.Provides;

/**
 * @author imac
 * @date 18/9/21
 */

@Module
public class SimpleModule  {
    private SimpleContract.View view;

    public SimpleModule(SimpleContract.View view) {
        this.view = view;
    }

    @Provides
    public SimpleContract.View provideView() {
        return view;
    }

    @Provides
    public SimpleContract.Model provideModel() {
        return new SimpleModel();
    }

    @Provides
    public SimpleContract.Presenter providerPersenter(SimpleContract.Model model, SimpleContract.View view) {
        return new SimplePresenter(model, view);
    }
}
