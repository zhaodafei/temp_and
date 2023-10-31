package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fei00MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei00_menu);

        // 返回首页
        Button HomeButton = findViewById(R.id.feiMenu00_home);
        HomeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Fei00MenuActivity.this, MainActivity.class);
                startActivity(intent); // 注意这个方法,不要选错了,这个方法有多个,参数不一样
            }
        });

        // 去foo页面
        Button MenuBtn00F = findViewById(R.id.feiMenu00_foo);
        MenuBtn00F.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Fei00MenuActivity.this, FooActivity.class);
                startActivity(intent); // 注意这个方法,不要选错了,这个方法有多个,参数不一样
            }
        });
        // 去foo页面
        Button MenuBtn00B = findViewById(R.id.feiMenu00_bar);
        MenuBtn00B.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Fei00MenuActivity.this, BarActivity.class);
                startActivity(intent); // 注意这个方法,不要选错了,这个方法有多个,参数不一样
            }
        });

        // ==================================
        // 第一个页面
        Button MenuBtn01 = findViewById(R.id.feiMenu01_link);
        MenuBtn01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Fei00MenuActivity.this, Fei01Activity.class);
                startActivity(intent); // 注意这个方法,不要选错了,这个方法有多个,参数不一样
            }
        });
    }
}