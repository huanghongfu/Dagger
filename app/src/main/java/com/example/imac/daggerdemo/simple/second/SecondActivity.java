package com.example.imac.daggerdemo.simple.second;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.imac.daggerdemo.R;
import com.example.imac.daggerdemo.base.BaseActivity;
import com.example.imac.daggerdemo.component.AppComponent;
import com.example.imac.daggerdemo.databinding.ActivitySecondBinding;
import com.example.imac.daggerdemo.module.ActivityScope;
import com.example.imac.daggerdemo.simple.simple.SimpleActivity;
import com.example.imac.daggerdemo.simple.simple.ThridActivity;

/**
 * @author imac
 * @date 18/9/21
 */
@ActivityScope
public class SecondActivity extends BaseActivity<SecondContract.Presenter, ActivitySecondBinding> implements SecondContract.View {

    public static void start(Context context) {
        Intent starter = new Intent(context, SecondActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_second;
    }

    @Override
    protected void initProvider(AppComponent appComponent) {
        DaggerSecondComponent.builder().appComponent(appComponent).secondModule(new SecondModule(this)).build().inject(this);
    }

    @Override
    protected void initDatas() {
    }

    @Override
    protected void initListeners() {
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }
}
