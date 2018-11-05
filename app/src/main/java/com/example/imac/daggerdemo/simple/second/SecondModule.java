package com.example.imac.daggerdemo.simple.second;

import dagger.Module;
import dagger.Provides;

/**
 * @author imac
 * @date 18/9/21
 */
@Module
public class SecondModule {

    private SecondContract.View view;

    public SecondModule(SecondContract.View view) {
        this.view = view;
    }

    @Provides
    public SecondContract.View provideView() {
        return view;
    }

    @Provides
    public SecondContract.Model provideModel() {
        return new SecondModel();
    }

    @Provides
    public SecondContract.Presenter providerPersenter(SecondContract.Model model, SecondContract.View view) {
        return new SecondPersenter(model, view);
    }
}
