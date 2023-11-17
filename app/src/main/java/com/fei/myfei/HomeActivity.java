package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 隐藏标题栏
        // getSupportActionBar().hide();

        // 关联静态布局页面
        setContentView(R.layout.activity_home);

        // 创建子线程
        Thread mThread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(2000);// 使程序休眠2秒
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        mThread.start();// 启动线程

    }
}