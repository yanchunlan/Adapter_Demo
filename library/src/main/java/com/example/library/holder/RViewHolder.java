package com.example.library.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author:  ycl
 * date:  2019/09/02 8:08
 * desc:
 */
public class RViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mConvertView;

    public RViewHolder(@NonNull View itemView) {
        super(itemView);
        mConvertView = itemView;
        mViews = new SparseArray<>();
    }

    public static RViewHolder createHolder(Context context, ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        return new RViewHolder(itemView);
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if(view==null){
            view= mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T)view;
    }

    public View getConvertView() {
        return mConvertView;
    }
}
