package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.fei.myfei.adapter.PhoneImgPagerAdapter;
import com.fei.myfei.entity.PhoneInfo;
import com.fei.myfei.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class Fei12Activity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private static final String TAG = "Fei12Activity_tag"; // 日志标记

    private ViewPager vp_content;
    private ArrayList<PhoneInfo> myPhoneList;

    private ViewPager vp_content2;
    private ArrayList<PhoneInfo> myPhoneList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei12);

        vp_content = findViewById(R.id.fei12_vp_01);
        myPhoneList = PhoneInfo.getDefaultList();
        PhoneImgPagerAdapter adapter = new PhoneImgPagerAdapter(this, myPhoneList);
        vp_content.setAdapter(adapter);
        vp_content.addOnPageChangeListener(this);

        // ================== PagerTitleStrip效果演示 ==========================
        initPagerStrip();
        initViewPager();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        // 翻页状态改变时触发,该方法的三个参数取值说明为: 第一个参数表示当前页面的序号
        // 第二个参数表示页面偏移的百分比,取值为0和1; 第三个参数表示页面的偏移距离
    }

    @Override
    public void onPageSelected(int position) {
        // 常用这个方法: 在翻页结束后触发, position 表示当前滑到了哪一个页面
        ToastUtils.show(this, "???反正你是滑动了,不知道是上面还是下面???");
        Log.d(TAG, "onPageSelected: 我也不知道这里怎么区分2个ViewPager监听");
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        // 翻页状态改变时触发,state取值说明为: 0表示静止, 1表示正在滑动, 2表示滑动完毕
        // 在翻页过程中, 状态值变化依次为: 正在滑动-->滑动完毕-->静止
    }

    // ================== ↓↓↓ PagerTitleStrip效果演示  ↓↓↓==========================
    // 初始化翻页标题栏
    private void initPagerStrip() {
        PagerTabStrip pts_tab = findViewById(R.id.fei12_pts_tab);
        // 设置翻页标签栏的文本大小
        pts_tab.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        pts_tab.setTextColor(Color.BLACK);
    }
    // 初始化翻页内容栏
    private void initViewPager() {
        vp_content2 = findViewById(R.id.fei12_vp_02);
        myPhoneList2 = PhoneInfo.getDefaultList();
        PhoneImgPagerAdapter adapter = new PhoneImgPagerAdapter(this, myPhoneList2);
        vp_content2.setAdapter(adapter);
        vp_content2.addOnPageChangeListener(this);
    }
}