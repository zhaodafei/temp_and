package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 按钮跳转开始
        Button HomeButton = findViewById(R.id.home_button);
        HomeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                // intent.setClass(MainActivity.this, FooActivity.class);
                intent.setClass(MainActivity.this, Fei00MenuActivity.class);
                startActivity(intent); // 注意这个方法,不要选错了,这个方法有多个,参数不一样
            }
        });
    }
}