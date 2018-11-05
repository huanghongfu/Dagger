package com.example.imac.daggerdemo.simple.simple;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.imac.daggerdemo.R;

/**
 * @author imac
 * @date 18/9/30
 */

public class ThridActivity extends SimpleActivity {
    public static void start(Context context) {
        Intent starter = new Intent(context, ThridActivity.class);
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
        FourActivity.start(mContext);
    }
}
