package com.example.imac.daggerdemo.simple.second;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.imac.daggerdemo.R;
import com.example.imac.daggerdemo.base.BaseActivity;
import com.example.imac.daggerdemo.component.AppComponent;
import com.example.imac.daggerdemo.databinding.ActivitySecondBinding;
import com.example.imac.daggerdemo.module.ActivityScope;
import com.example.imac.daggerdemo.simple.simple.SimpleActivity;
import com.example.imac.daggerdemo.simple.simple.ThridActivity;

import java.util.ArrayList;

/**
 * @author imac
 * @date 18/9/21
 */
@ActivityScope
public class SecondActivity extends BaseActivity<SecondContract.Presenter, ActivitySecondBinding> implements SecondContract.View {

    private CustomAdapter mAdapter;

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
        mBinding.recyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
        mBinding.recyclerView.setAdapter(mAdapter = new CustomAdapter(null));

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (TextUtils.isEmpty(mAdapter.getItem(position))) {
                    //去拍照
                    Toast.makeText(mApp, "去拍照", Toast.LENGTH_SHORT).show();
                    mAdapter.addData(0, "去拍照");
                } else {
                    mAdapter.remove(position);
                    Toast.makeText(mApp, "点击了删除", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mBinding.recyclerView.getAdapter().registerAdapterDataObserver(new RecyclerViewObserver(10, mAdapter, RecyclerViewObserver.ADD_TYPE_SHUN));

        mAdapter.setNewData(new ArrayList<String>());
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
