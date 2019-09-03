package com.example.adapter_demo.mult;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.adapter_demo.R;
import com.example.adapter_demo.bean.UserInfo;
import com.example.library.activity.BaseRViewActivity;
import com.example.library.base.RViewAdapter;
import com.example.library.listener.ItemListener;

import java.util.ArrayList;
import java.util.List;

public class MultActivity extends BaseRViewActivity {

    private List<UserInfo> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDatas();
    }

    private void initDatas() {
        if (datas.isEmpty()) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 15; i++) {
                        for (int j = 1; j <= 15; j++) {
                            UserInfo user = new UserInfo();
                            if (j % 15 == 1) {
                                user.setType(1);
                                user.setAccount("Learn >>>>>>>>> 11111 >>>>>>>>>");
                            } else if (j % 15 == 2 || j % 15 == 3) {
                                user.setType(2);
                                user.setAccount("Learn >>>>>>> 22222 >>>>>>>");
                            } else if (j % 15 == 4 || j % 15 == 5 || j % 15 == 6) {
                                user.setType(3);
                                user.setAccount("Learn >>>>> 33333 >>>>>");
                            } else if (j % 15 == 7 || j % 15 == 8 || j % 13 == 9 || j % 15 == 10) {
                                user.setType(4);
                                user.setAccount("Learn >>> 44444 >>>");
                            } else {
                                user.setType(5);
                                user.setAccount("Learn > 55555 >");
                            }
                            datas.add(user);
                        }
                    }
                }
            });
        }
        notifyAdapterDataSetChanged(datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recycleview;
    }

    @Override
    public void onRefresh() {
        initDatas();
    }

    @Override
    public RViewAdapter createRecycleViewAdapter() {
        RViewAdapter adapter = new RViewAdapter(datas);
        adapter.addItemStyle(new AItem());
        adapter.addItemStyle(new BItem());
        adapter.addItemStyle(new CItem());
        adapter.addItemStyle(new DItem());
        adapter.addItemStyle(new EItem());
        adapter.setItemListener(new ItemListener<UserInfo>() {

            @Override
            public void onItemClick(View view, UserInfo entity, int position) {
                Toast.makeText(MultActivity.this, "position: " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(View view, UserInfo entity, int position) {
                Toast.makeText(MultActivity.this, "position: " + position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return adapter;
    }
}
