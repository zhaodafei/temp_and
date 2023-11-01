package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Fei02Activity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = "fei_abc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei02);
        Log.d(TAG, "onCreate: 内容 111111111");
        findViewById(R.id.fei02_btn1).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, Fei021Activity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: 内容 222222222");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: 内容 333333333333");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: 内容 4444444444");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: 内容 555555555");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: 内容 6666666666");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: 内容 77777777777");
    }
}