package com.example.library.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.library.R;
import com.example.library.RViewHelper;
import com.example.library.listener.RViewCreate;

import java.util.List;

/**
 * author:  ycl
 * date:  2019/09/03 15:11
 * desc:
 */
public abstract class BaseRViewActivity extends AppCompatActivity implements RViewCreate, SwipeRefreshLayout.OnRefreshListener {
    private RViewHelper helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        helper = new RViewHelper.Builder(this, this).build();
    }

    protected abstract int getLayoutId();
   /* @Override
    public void onRefresh() {

    }*/

    @Override
    public SwipeRefreshLayout createSwipeRefreshLayout() {
        return findViewById(R.id.swipeRefreshLayout);
    }

    @Override
    public int[] colorRes() {
        return new int[0];
    }

    @Override
    public RecyclerView createRecycleView() {
        return findViewById(R.id.recyclerView);
    }

    /* @Override
     public RViewAdapter createRecycleViewAdapter() {
         return null;
     }
 */
    @Override
    public RecyclerView.LayoutManager createLayoutManager() {
        return new LinearLayoutManager(this);
    }

    @Override
    public RecyclerView.ItemDecoration createItemDecoration() {
        return new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
    }

    @Override
    public int startPageNumber() {
        return 1;
    }

    @Override
    public boolean isSupportPaging() {
        return false;
    }

    public void notifyAdapterDataSetChanged(List datas) {
        helper.notifyAdapterDataSetChanged(datas);
    }
}