package com.example.library.manager;

import android.support.v4.util.SparseArrayCompat;

import com.example.library.holder.RViewHolder;
import com.example.library.listener.RViewItem;

/**
 * author:  ycl
 * date:  2019/09/03 13:48
 * desc:  多样式管理器
 */
public class RViewItemManager<T> {

    // 定义有几种样式
    // 样式的key是动态递增的
    private SparseArrayCompat<RViewItem<T>> styles = new SparseArrayCompat<>();

    public void addStyles(RViewItem<T> item) {
        if (item != null) {
            // 累加的效果
            styles.put(styles.size(), item);
        }
    }

    public int getItemViewStylesCount() {
        return styles.size();
    }

    public RViewItem<T> getRViewItem(int viewType) {
        return styles.get(viewType);
    }

    public int getItemViewType(T entity, int position) {
        // 倒叙是为了，解决同时添删异常
        for (int i = styles.size() - 1; i >= 0; i--) {
            RViewItem<T> item = styles.valueAt(i);
            if (item.isItemView(entity, position)) {
                return styles.keyAt(i);
            }
        }
        throw new IllegalArgumentException("no styles");
    }

    public void convert(RViewHolder holder, T entity, int position) {
        for (int i = 0; i < styles.size(); i++) {
            RViewItem<T> item = styles.valueAt(i);
            if (item.isItemView(entity, position)) {
                item.convert(holder, entity, position);
                return;
            }
        }
        throw new IllegalArgumentException("no styles");
    }
}
