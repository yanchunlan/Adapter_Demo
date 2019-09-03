package com.example.library;

import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

/**
 * author:  ycl
 * date:  2019/09/03 13:49
 * desc:
 */
public class SwipeRefreshHelper {

    private SwipeRefreshLayout swipeRefreshLayout;
    private SwipeRefreshLayout.OnRefreshListener refreshListener;

    static SwipeRefreshHelper createSwipeRefreshHelper(SwipeRefreshLayout swipeRefreshLayout,
                                                       @ColorRes int... colorResIds) {
        return new SwipeRefreshHelper(swipeRefreshLayout, colorResIds);
    }

    private SwipeRefreshHelper(@Nullable SwipeRefreshLayout swipeRefreshLayout,
                               @ColorRes int... colorResIds) {
        this.swipeRefreshLayout = swipeRefreshLayout;
        init(colorResIds);
    }

    private void init(@ColorRes int... colorResIds) {
        if (colorResIds == null || colorResIds.length == 0) {
            swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_orange_dark,
                    android.R.color.holo_green_dark, android.R.color.holo_blue_dark);
        } else {
            swipeRefreshLayout.setColorSchemeResources(colorResIds);
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (refreshListener != null) {
                    refreshListener.onRefresh();
                }
            }
        });
    }

    public void setRefreshListener(SwipeRefreshLayout.OnRefreshListener refreshListener) {
        this.refreshListener = refreshListener;
    }
}
