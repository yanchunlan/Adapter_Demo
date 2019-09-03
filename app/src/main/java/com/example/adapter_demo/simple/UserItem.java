package com.example.adapter_demo.simple;

import android.widget.TextView;

import com.example.adapter_demo.bean.UserInfo;
import com.example.library.holder.RViewHolder;
import com.example.library.listener.RViewItem;

/**
 * author:  ycl
 * date:  2019/09/03 16:19
 * desc:
 */
public class UserItem implements RViewItem<UserInfo> {
    @Override
    public int getItemLayout() {
        return android.R.layout.simple_list_item_1;
    }

    @Override
    public boolean openClick() {
        return true;
    }

    @Override
    public boolean isItemView(UserInfo entity, int position) {
        return true;
    }

    @Override
    public void convert(RViewHolder holder, UserInfo entity, int position) {
        TextView textView = holder.getView(android.R.id.text1);
        textView.setText(entity.toString());
    }
}
