package com.example.adapter_demo.simple;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.adapter_demo.R;
import com.example.adapter_demo.bean.UserInfo;
import com.example.library.activity.BaseRViewActivity;
import com.example.library.base.RViewAdapter;
import com.example.library.listener.ItemListener;

import java.util.ArrayList;
import java.util.List;

public class SimpleActivity extends BaseRViewActivity {

    private List<UserInfo> datas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDatas();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recycleview;
    }

    private void initDatas() {
        if (datas.isEmpty()) {
            for (int i = 0; i < 100; i++) {
                datas.add(new UserInfo("learn", "123456"));
            }
        }
        notifyAdapterDataSetChanged(datas);
    }

    @Override
    public RViewAdapter createRecycleViewAdapter() {
        RViewAdapter adapter = new RViewAdapter(datas, new UserItem());
        adapter.setItemListener(new ItemListener<UserInfo>(){

            @Override
            public void onItemClick(View view, UserInfo entity, int position) {
                Toast.makeText(SimpleActivity.this, "position: "+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(View view, UserInfo entity, int position) {
                Toast.makeText(SimpleActivity.this, "position: "+position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return adapter;
    }

    @Override
    public void onRefresh() {
        initDatas();
    }
}
