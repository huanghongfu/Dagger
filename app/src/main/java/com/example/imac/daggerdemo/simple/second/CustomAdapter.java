package com.example.imac.daggerdemo.simple.second;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.imac.daggerdemo.R;

import java.util.List;

/**
 * @author imac
 * @date 18/11/6
 */

public class CustomAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public CustomAdapter(List<String> data) {
        super(R.layout.item_picture_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageView ivImage = helper.getView(R.id.iv_image);
        ImageView ivClose = helper.getView(R.id.iv_close);

        if (TextUtils.isEmpty(item)) {
            ivImage.setImageResource(R.mipmap.add_icon);
            ivClose.setVisibility(View.GONE);
        } else {
            ivImage.setImageResource(R.mipmap.ic_launcher);
            ivClose.setVisibility(View.VISIBLE);
        }
    }
}
