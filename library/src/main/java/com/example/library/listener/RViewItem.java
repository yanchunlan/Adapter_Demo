package com.example.library.listener;

import com.example.library.holder.RViewHolder;

/**
 * author:  ycl
 * date:  2019/09/03 13:41
 * desc:  adapter 比作一个item处理
 */
public interface RViewItem<T> {
    int getItemLayout();

    boolean openClick();

    boolean isItemView(T entity, int position);

    void convert(RViewHolder holder, T entity, int position);
}
