package com.example.library.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.library.holder.RViewHolder;
import com.example.library.listener.ItemListener;
import com.example.library.listener.RViewItem;
import com.example.library.manager.RViewItemManager;

import java.util.ArrayList;
import java.util.List;

/**
 * author:  ycl
 * date:  2019/09/03 13:47
 * desc:
 */
public class RViewAdapter<T> extends RecyclerView.Adapter<RViewHolder> {
    private RViewItemManager<T> itemStyle;// 缓存-样式管理
    private ItemListener<T> itemListener;// 缓存-样式监听器
    private List<T> datas;

    public void addDatas(List<T> datas) {
        if (datas == null) return;
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public void updateDatas(List<T> datas) {
        if (datas == null) return;
        this.datas = datas;
        notifyDataSetChanged();
    }

    public RViewAdapter(List<T> datas) {
        if (datas == null) this.datas = new ArrayList<>();
        this.datas = datas;
        itemStyle = new RViewItemManager<>();
    }

    public RViewAdapter(List<T> datas, RViewItem<T> item) {
        this(datas);
        addItemStyle(item);
    }

    public void addItemStyle(RViewItem<T> item) {
        itemStyle.addStyles(item);
    }

    public void setItemListener(ItemListener<T> itemListener) {
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public RViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RViewItem item = itemStyle.getRViewItem(viewType);
        int layoutId = item.getItemLayout();
        RViewHolder holder = RViewHolder.createHolder(viewGroup.getContext(), viewGroup, layoutId);
        if (item.openClick()) {
            setListener(holder);
        }
        return holder;
    }

    private void setListener(final RViewHolder holder) {
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemListener != null) {
                    int position = holder.getAdapterPosition();
                    itemListener.onItemClick(v, datas.get(position), position);
                }
            }
        });
        holder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (itemListener != null) {
                    int position = holder.getAdapterPosition();
                    return itemListener.onItemLongClick(v, datas.get(position), position);
                }
                return false;
            }
        });
    }

    @Override
    public void onBindViewHolder(@NonNull RViewHolder holder, int i) {
        itemStyle.convert(holder, datas.get(i), i);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (itemStyle.getItemViewStylesCount() > 0) {
            itemStyle.getItemViewType(datas.get(position), position);
        }
        return super.getItemViewType(position);
    }
}
