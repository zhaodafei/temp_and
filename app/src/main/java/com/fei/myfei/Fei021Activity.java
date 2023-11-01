package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Fei021Activity extends AppCompatActivity implements View.OnClickListener{

    private static final String mResponse = "我很好,返回给你";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei021);

        TextView tv_request = findViewById(R.id.fei021_text1);
        // 从上个页面传递过来的数据包裹
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String request_time = bundle.getString("request_time");
            String request_content = bundle.getString("request_content");
            String desc = String.format("接受到内容为%s,和%s", request_time, request_content);
            // 接收请求到内容显示出来
            tv_request.setText(desc);
        }



        findViewById(R.id.fei021_btn1).setOnClickListener(this); // 完成按钮
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("request_time", "2023年12月12日22:31:45");
        bundle.putString("request_content", mResponse);
        intent.putExtras(bundle);
        // 携带信息返回上个页面,RESULT_OK表示处理成功
        setResult(Activity.RESULT_OK, intent);
        // 结束当前活动页面
        finish();
    }
}