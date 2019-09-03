package com.example.adapter_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.adapter_demo.mult.MultActivity;
import com.example.adapter_demo.simple.SimpleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSimple;
    private Button btnMult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        btnSimple = (Button) findViewById(R.id.btn_simple);
        btnMult = (Button) findViewById(R.id.btn_mult);

        btnSimple.setOnClickListener(this);
        btnMult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_simple:
                startActivity(new Intent(this, SimpleActivity.class));
                break;
            case R.id.btn_mult:
                startActivity(new Intent(this, MultActivity.class));
                break;
        }
    }
}
