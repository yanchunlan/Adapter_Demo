package com.example.library;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.library.base.RViewAdapter;
import com.example.library.listener.RViewCreate;

import java.util.List;

/**
 * author:  ycl
 * date:  2019/09/03 13:49
 * desc:
 */
public class RViewHelper<T> {
    private SwipeRefreshLayout swipeRefreshLayout;
    private SwipeRefreshLayout.OnRefreshListener onRefreshListener;
    private RecyclerView recyclerView;
    private RViewAdapter<T> adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.ItemDecoration itemDecoration;
    private int startPageNumber;
    private boolean isSupportPaging;
    private int currentPageNum;

    private SwipeRefreshHelper swipeRefreshHelper;


    public RViewHelper(Builder<T> builder) {
        this.swipeRefreshLayout = builder.create.createSwipeRefreshLayout();
        this.onRefreshListener = builder.onRefreshListener;
        this.recyclerView = builder.create.createRecycleView();
        this.adapter = builder.create.createRecycleViewAdapter();
        this.layoutManager = builder.create.createLayoutManager();
        this.itemDecoration = builder.create.createItemDecoration();
        this.startPageNumber = builder.create.startPageNumber();
        this.isSupportPaging = builder.create.isSupportPaging();

        this.currentPageNum = this.startPageNumber;
        int[] colorRes = builder.create.colorRes();
        if (swipeRefreshLayout != null) {
            swipeRefreshHelper = SwipeRefreshHelper.createSwipeRefreshHelper(swipeRefreshLayout, colorRes);
        }
        init();
    }

    private void init() {
        recyclerView.setLayoutManager(layoutManager);
         recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        if (itemDecoration != null) recyclerView.addItemDecoration(itemDecoration);
        if (swipeRefreshHelper != null) {
            swipeRefreshHelper.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    currentPageNum = startPageNumber;
                    // 根据此处的逻辑看出，是dismiss之后在刷新数据
                    dismissSwipeRefresh();
                    if (onRefreshListener != null) {
                        onRefreshListener.onRefresh();
                    }
                }
            });
        }
    }

    private void dismissSwipeRefresh() {
        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    public RViewAdapter<T> getAdapter() {
        return adapter;
    }

    // 刷新数据并setAdapter
    public void notifyAdapterDataSetChanged(List<T> datas) {
        if (currentPageNum == startPageNumber) {
            adapter.updateDatas(datas);
        } else {
            adapter.addDatas(datas);
        }
       /* recyclerView.setAdapter(adapter);*/

        if (isSupportPaging) {
            Log.e(this.getClass().getName(), "isSupportPaging = true");
        }
    }


    public static class Builder<T> {
        private RViewCreate<T> create;
        private SwipeRefreshLayout.OnRefreshListener onRefreshListener;

        public Builder(RViewCreate<T> create, SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.create = create;
            this.onRefreshListener = onRefreshListener;
        }

        public RViewHelper build() {
            return new RViewHelper(this);
        }
    }
}
