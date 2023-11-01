package com.fei.myfei;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fei.myfei.utils.UnitUtils;

public class FooActivity extends AppCompatActivity  {
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

        // // 05)接受其他页面跳转过来的参数
        // Bundle extras = getIntent().getExtras();
        // Object params1 = extras.getString("params_fei1");
        // Object params2 = extras.getString("params_fei2");
        // TextView fooText03 = findViewById(R.id.foo_text03);
        // String allParams = String.format("参数1为%s: ", params1);
        // // fooText03.setText("ssssssssss");
        // fooText03.setText(allParams);


        // 06)返回按钮开始
        Button FooButton4 = findViewById(R.id.foo_button4);
        FooButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("response_01","我是返回上个activity参数1");
                bundle.putString("response_02","我是返回上个activity参数2");
                intent.putExtras(bundle);
                // 携带信息返回上个页面,RESULT_OK表示处理成功
                setResult(Activity.RESULT_OK, intent);
                // 结束当前活动页面
                finish();
            }
        });


    }
}
