package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Fei021Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei021);

        findViewById(R.id.fei021_btn1).setOnClickListener(this); // 完成按钮
    }

    @Override
    public void onClick(View v) {
        // 结束当前活动页面
        finish();
    }
}