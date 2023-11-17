package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;

import com.fei.myfei.adapter.MobilePagerAdapter;
import com.fei.myfei.adapter.PhoneImgPagerAdapter;
import com.fei.myfei.entity.PhoneInfo;

import java.util.ArrayList;

public class Fei14Activity extends AppCompatActivity {

    private ViewPager vp_content;
    private ArrayList<PhoneInfo> myPhoneList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei14);

        initPagerStrip();
        initViewPager();
    }

    // 初始化翻页标题栏
    private void initPagerStrip() {
        PagerTabStrip pts_tab = findViewById(R.id.fei14_pts_tab);
        // 设置翻页标签栏的文本大小
        pts_tab.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        pts_tab.setTextColor(Color.BLACK);
    }
    // 初始化翻页内容栏
    private void initViewPager() {
        vp_content = findViewById(R.id.fei14_vp);
        myPhoneList = PhoneInfo.getDefaultList();
        // 开始处理数据
        MobilePagerAdapter adapter = new MobilePagerAdapter(getSupportFragmentManager(), myPhoneList);
        vp_content.setAdapter(adapter);
    }
}