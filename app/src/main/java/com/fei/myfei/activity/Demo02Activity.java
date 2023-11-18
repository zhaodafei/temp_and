package com.fei.myfei.activity;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.fei.myfei.R;
import com.fei.myfei.fragment.Demo01HomeFragment;
import com.fei.myfei.fragment.Demo01MyFragment;

public class Demo02Activity extends AppCompatActivity {

    private RadioGroup rg_tabMenu;
    private Demo01HomeFragment homePage;
    private Demo01MyFragment myPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo02);

        initView(); // 初始化页面
    }

    private void initView() {
      // .......
    }


}