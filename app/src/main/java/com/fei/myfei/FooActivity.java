package com.fei.myfei;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FooActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 这个 onCreate 要选这个只有一个参数的
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foo);

        // 返回按钮开始
        Button FooButton = findViewById(R.id.foo_button);
        FooButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(FooActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
