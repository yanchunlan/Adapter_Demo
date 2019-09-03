package com.example.adapter_demo.mult;

import android.widget.TextView;

import com.example.adapter_demo.R;
import com.example.adapter_demo.bean.UserInfo;
import com.example.library.holder.RViewHolder;
import com.example.library.listener.RViewItem;


public class EItem implements RViewItem<UserInfo> {

    @Override
    public int getItemLayout() {
        return R.layout.item_e;
    }

    @Override
    public boolean openClick() {
        return false;
    }

    @Override
    public boolean isItemView(UserInfo entity, int position) {
        return entity.getType() == 5;
    }

    @Override
    public void convert(RViewHolder holder, UserInfo entity, int position) {
        TextView textView = holder.getView(R.id.mtv);
        textView.setText(entity.getAccount());
    }
}
