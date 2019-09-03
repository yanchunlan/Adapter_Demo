package com.example.library.listener;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.example.library.base.RViewAdapter;

/**
 * author:  ycl
 * date:  2019/09/03 14:30
 * desc:   管理列表及其刷新器
 */
public interface RViewCreate<T> {

    SwipeRefreshLayout createSwipeRefreshLayout();

    int[] colorRes();

    RecyclerView createRecycleView();

    RViewAdapter<T> createRecycleViewAdapter();

    RecyclerView.LayoutManager createLayoutManager();

    RecyclerView.ItemDecoration createItemDecoration();

    int startPageNumber(); // 开始页码

    boolean isSupportPaging();// 是否支持分页
}
