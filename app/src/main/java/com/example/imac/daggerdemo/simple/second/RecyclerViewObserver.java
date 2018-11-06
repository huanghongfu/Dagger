package com.example.imac.daggerdemo.simple.second;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;

/**
 * @author imac
 * @date 18/11/6
 */

public class RecyclerViewObserver extends RecyclerView.AdapterDataObserver {

    private static final String TAG = "RecyclerViewObserver";

    private int mMaxSize;
    private BaseQuickAdapter mBaseQuickAdapter;
    public static final int ADD_TYPE_ZHENG = 0;//一直在0的位置
    public static final int ADD_TYPE_SHUN = 1;//填充图片的后方

    private int mAddType;

    public RecyclerViewObserver(int maxSize, BaseQuickAdapter adapter, int addType) {
        mMaxSize = maxSize;
        mBaseQuickAdapter = adapter;
        this.mAddType = addType;
    }

    @Override
    public void onChanged() {
        super.onChanged();
        Log.e(TAG, "onChanged: ");
        onChange();
    }

    @Override
    public void onItemRangeChanged(int positionStart, int itemCount) {
        super.onItemRangeChanged(positionStart, itemCount);
        Log.e(TAG, "onItemRangeChanged: ");
        onChange();
    }

    @Override
    public void onItemRangeChanged(int positionStart, int itemCount, @Nullable Object payload) {
        super.onItemRangeChanged(positionStart, itemCount, payload);
        Log.e(TAG, "onItemRangeChanged: ");
        onChange();
    }

    @Override
    public void onItemRangeInserted(int positionStart, int itemCount) {
        super.onItemRangeInserted(positionStart, itemCount);
        Log.e(TAG, "onItemRangeInserted: ");
        onChange();
    }

    @Override
    public void onItemRangeRemoved(int positionStart, int itemCount) {
        super.onItemRangeRemoved(positionStart, itemCount);
        Log.e(TAG, "onItemRangeRemoved: ");
        onChange();
    }

    @Override
    public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
        super.onItemRangeMoved(fromPosition, toPosition, itemCount);
        Log.e(TAG, "onItemRangeMoved: ");
    }

    public void onChange() {
        //未到达最大值
        if (mBaseQuickAdapter.getData().size() < mMaxSize && !mBaseQuickAdapter.getData().contains("")) {
            if (mAddType == ADD_TYPE_SHUN) {
                mBaseQuickAdapter.addData(mBaseQuickAdapter.getData().size(), "");
            } else {
                mBaseQuickAdapter.addData(0, "");
            }
        }
        //已到达最大值
        if (mBaseQuickAdapter.getData().size() > mMaxSize && mBaseQuickAdapter.getData().contains("")) {
            mBaseQuickAdapter.remove(mBaseQuickAdapter.getData().indexOf(""));
        }
    }
}
