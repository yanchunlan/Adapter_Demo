package com.example.library.listener;

import android.view.View;

/**
 * author:  ycl
 * date:  2019/09/02 8:15
 * desc:
 */
public interface ItemListener<T> {
    void onItemClick(View view, T entity, int position);
//    void onItemClick(View view, T entity, int position);

}
