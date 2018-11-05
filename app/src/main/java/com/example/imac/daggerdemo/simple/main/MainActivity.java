package com.example.imac.daggerdemo.simple.main;

import android.graphics.Color;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.imac.daggerdemo.R;
import com.example.imac.daggerdemo.base.BaseActivity;
import com.example.imac.daggerdemo.component.AppComponent;
import com.example.imac.daggerdemo.databinding.ActivityMainBinding;
import com.example.imac.daggerdemo.module.ActivityScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


@ActivityScope
public class MainActivity extends BaseActivity<MainContract.Persenter, ActivityMainBinding> implements MainContract.View {

    private LinearLayoutManager mLinearLayoutManager1;
    private LinearLayoutManager mLinearLayoutManager2;
    private BaseQuickAdapter<TitleBean, BaseViewHolder> mAdapter1;
    private BaseQuickAdapter<String, BaseViewHolder> mAdapter2;
    private int mPosition;
    private List<TitleBean> mLeftMenu;
    private boolean isHeaderByPerson;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initProvider(AppComponent appComponent) {
        DaggerMainComonpent
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initDatas() {
        mBinding.recyclerView1.setLayoutManager(mLinearLayoutManager1 = new LinearLayoutManager(this));
        mBinding.recyclerView2.setLayoutManager(mLinearLayoutManager2 = new LinearLayoutManager(this));
        mBinding.recyclerView2.addItemDecoration(new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));

        mBinding.recyclerView1
                .setAdapter(mAdapter1 = new BaseQuickAdapter<TitleBean, BaseViewHolder>(R.layout.item_left_layout, mLeftMenu = getTitleData()) {
                    @Override
                    protected void convert(BaseViewHolder helper, TitleBean item) {
                        helper.setText(R.id.tv_left, item.title);
                        if (item.isChecked) {
                            helper.setTextColor(R.id.tv_left, Color.GREEN);
                        } else {
                            helper.setTextColor(R.id.tv_left, Color.BLACK);
                        }
                    }
                });

        mBinding.recyclerView2.setAdapter(mAdapter2 = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_right_layout, getRightData()) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.tv_right, item);
            }
        });

        mBinding.recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!isHeaderByPerson) {
                    int firstVisibleItemPosition = mLinearLayoutManager2.findFirstVisibleItemPosition();
                    List<TitleBean> titleData = mLeftMenu;
                    int position = titleData.size() - 1;

                    for (int i = 0; i < titleData.size(); i++) {
                        if (titleData.get(i).getEndIndex() >= firstVisibleItemPosition) {
                            position = i;
                            break;
                        }
                    }

                    if (mPosition == position) {
                        return;
                    }


                    for (TitleBean bean : mAdapter1.getData()) {
                        bean.isChecked = false;
                    }

                    mAdapter1.getItem(position).isChecked = true;

                    mAdapter1.notifyDataSetChanged();

                    mPosition = position;
                    isHeaderByPerson = false;
                }
            }
        });

        mAdapter1.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                isHeaderByPerson = true;
                TitleBean item = mLeftMenu.get(position);
                if (item.isChecked) {
                    return;
                }

                for (TitleBean bean : mLeftMenu) {
                    bean.isChecked = false;
                }

                item.isChecked = true;
                mAdapter1.notifyDataSetChanged();
                mBinding.recyclerView2.scrollToPosition(item.getStartIndex());

            }
        });
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

    Random mRandom = new Random();

    int maxLength;

    public List<String> getRightData() {
        List<String> data = new ArrayList<>();
        List<TitleBean> titleData = mAdapter1.getData();
        for (int i = 0; i < titleData.size(); i++) {
            maxLength = 10 + mRandom.nextInt(10);
            for (int j = 0; j < maxLength; j++) {
                TitleBean item = titleData.get(i);
                String s = item.title + j;
                data.add(s);
                if (j == 0) {
                    int t = data.indexOf(item.title + j);
                    item.setStartIndex(t);
                }

                if (j == maxLength - 1) {
                    int t = data.indexOf(item.title + j);
                    item.setEndIndex(t);
                }
            }
        }

        for (TitleBean bean : titleData) {
            Log.e("HHH", "startIndex=" + bean.startIndex + "   endIndex=" + bean.endIndex);
        }
        return data;
    }


    public List<TitleBean> getTitleData() {
        ArrayList<TitleBean> objects = new ArrayList<>();
        objects.add(new TitleBean("古文", true));
        objects.add(new TitleBean("普通话"));
        objects.add(new TitleBean("香港话"));
        objects.add(new TitleBean("广州话"));
        objects.add(new TitleBean("家乡话"));
        return objects;
    }

    class TitleBean {
        String title;
        boolean isChecked;
        int startIndex;
        int endIndex;


        public TitleBean(String title, boolean isChecked) {
            this.title = title;
            this.isChecked = isChecked;
        }

        public TitleBean(String title) {
            this.title = title;
            this.isChecked = false;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean checked) {
            isChecked = checked;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }
    }
}
