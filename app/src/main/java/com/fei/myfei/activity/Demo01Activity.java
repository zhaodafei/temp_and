package com.fei.myfei.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.fei.myfei.R;
import com.fei.myfei.fragment.Demo01HomeFragment;
import com.fei.myfei.fragment.Demo01MyFragment;

public class Demo01Activity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg_tabMenu;
    private Demo01HomeFragment homePage;
    private Demo01MyFragment myPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo01);

        initView(); // 初始化页面
    }

    private void initView() {
        // 默认一个菜单
        setDefaultPage();

        // 切换菜单显示页面
        rg_tabMenu = findViewById(R.id.d01_tab_menu);
        rg_tabMenu.setOnCheckedChangeListener(this);
    }

    // 设置默认菜单页面
    public void setDefaultPage() {
        homePage = new Demo01HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.d01_main_content, homePage).commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        if (checkedId == R.id.d01_home_page) {
            setDefaultPage();
        } else if (checkedId == R.id.d01_my_page) {
            myPage = new Demo01MyFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.d01_main_content, myPage).commit();
        }
    }
}