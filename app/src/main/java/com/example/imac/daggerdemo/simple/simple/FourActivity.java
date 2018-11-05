package com.example.imac.daggerdemo.simple.simple;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.imac.daggerdemo.R;
import com.example.imac.daggerdemo.simple.main.MainActivity;
import com.example.imac.daggerdemo.simple.second.SecondActivity;

/**
 * @author imac
 * @date 18/9/30
 */

public class FourActivity extends SimpleActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, FourActivity.class);
        context.startActivity(starter);
    }
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_simple;
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initListeners() {

    }

    public void onclick(View view){
        SecondActivity.start(mContext);
    }
}
