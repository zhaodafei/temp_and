package com.fei.myfei;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fei.myfei.utils.UnitUtils;

public class FooActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 这个 onCreate 要选这个只有一个参数的
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foo);

        // 01)返回按钮开始
        Button FooButton = findViewById(R.id.foo_button);
        FooButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(FooActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // 01-2)去第三页按钮
        Button FooButton2 = findViewById(R.id.foo_button2);
        FooButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(FooActivity.this, BarActivity.class);
                startActivity(intent);
            }
        });

        // 02)页面内容重新赋值
        TextView fooText = findViewById(R.id.foo_text);
        // fooText.setText("我是新的内容");
        fooText.setText(R.string.foo_new_text1); // 设置文本内容
        fooText.setTextSize(25);  // 设置字体大小(默认单位sp)

        // 03) 文本颜色
        // fooText.setTextColor(Color.RED); // 设置文本颜色
        fooText.setTextColor(Color.parseColor("#FF6B81"));
        // fooText.setTextColor(getResources().getColor(R.color.fei_watermelon));

        // 03-2) 背景颜色
        // fooText.setBackgroundColor(Color.parseColor("#00FFFF")); // 背景颜色
        fooText.setBackgroundColor(getResources().getColor(R.color.fei_color_aqua)); // 背景颜色


        // 04)设置宽高
        TextView fooText02 = findViewById(R.id.foo_text02);
        // 获取布局参数(含宽度和高度)
        ViewGroup.LayoutParams params = fooText02.getLayoutParams();
        // 修改布局参数中的宽度值,注意默认px单位,把db数值转为px数值
        params.width = 100;
        // params.width = UnitUtils.dip2px(this,300);
        fooText02.setLayoutParams(params); // 设置布局参数
    }
}
