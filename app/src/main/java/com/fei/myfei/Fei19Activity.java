package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fei.myfei.service.Fei19Service;

public class Fei19Activity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei19);

        // 服务
        intent = new Intent(this, Fei19Service.class);
    }

    /**
     * 开启服务: 在布局文件中使用 onClick, 可以直接调用, 不建议这么写
     * @param view 按钮
     */
    public void start(View view) {
        startService(intent);
    }

    /**
     * 停止服务 在布局文件中使用 onClick, 可以直接调用, 不建议这么写
     * @param view 按钮
     */
    public void stop(View view) {
        stopService(intent);
    }
}