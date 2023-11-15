package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class Fei07Activity extends AppCompatActivity implements View.OnClickListener {

    private MyApplication myApp;
    private TextView fei07_tv01;
    private TextView fei07_tv02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei07);

        findViewById(R.id.fei07_btn01).setOnClickListener(this);
        fei07_tv01 = findViewById(R.id.fei07_tv01);
        fei07_tv02 = findViewById(R.id.fei07_tv02);

        myApp = MyApplication.getInstance();
        reload();
    }

    private void reload() {
        // if (myApp.infoMap.isEmpty()) {
        //     return;
        // }

        String bookName = myApp.infoMap.get("bookName");
        String author = myApp.infoMap.get("author");
        if (bookName == null || author==null) {
            return;
        }

        fei07_tv01.setText(bookName);
        fei07_tv02.setText(author);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fei07_btn01){
            // 开始给全局赋值
            myApp.infoMap.put("bookName", "全局赋值_图书名字__论语");
            myApp.infoMap.put("author", "全局赋值_作者__孔子");
        }
    }
}