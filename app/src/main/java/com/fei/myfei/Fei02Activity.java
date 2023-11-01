package com.fei.myfei;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Fei02Activity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = "Fei02Activity_tag"; // 日志标记
    private static final String mRequest = "我是第一个内容带走aaa";
    private ActivityResultLauncher<Intent> register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 执行  finish(); 这里的 onCreate 不会再次执行
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei02);
        Log.d(TAG, "onCreate: 内容 111111111");
        TextView tv_request = findViewById(R.id.fei02_text1);
        tv_request.setText("待发送消息为:" + mRequest);

        findViewById(R.id.fei02_btn1).setOnClickListener(this);

        // register = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        //     @Override
        //     public void onActivityResult(ActivityResult result) {
        //         // 执行  finish(); 这里的 onActivityResult 会执行到
        //         Log.d(TAG, "onActivityResult: 接受到了没有");
        //
        //         Intent intent = result.getData();
        //         if (intent != null && result.getResultCode() == Activity.RESULT_OK) {
        //             Bundle bundle = intent.getExtras();
        //             String response01 = bundle.getString("request_time");
        //             String response02 = bundle.getString("request_content");
        //
        //             Log.d("feiFoo", String.format("接受参数为:", response01));
        //
        //             TextView showResponseText = findViewById(R.id.fei02_text2_response);
        //             showResponseText.setText(response02);
        //         }
        //     }
        // });

        //  new ActivityResultCallback<ActivityResult> 被 result -> 代替了(新版中)
        register = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            // 执行  finish(); 这里的 onActivityResult 会执行到
            Log.d(TAG, "onActivityResult: 接受到了没有 ");

            Intent intent = result.getData();
            if (intent != null && result.getResultCode() == Activity.RESULT_OK) {
                Bundle bundle = intent.getExtras();
                String response01 = bundle.getString("request_time");
                String response02 = bundle.getString("request_content");

                Log.d("feiFoo", String.format("接受参数为:", response01));

                TextView showResponseText = findViewById(R.id.fei02_text2_response);
                showResponseText.setText(response02);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fei02_btn1) {
            // 不能用 startActivity 跳转了,要用 register.launch(intent);
            // startActivity(new Intent(this, Fei021Activity.class));

            // 创建一个数据包裹
            Intent intent = new Intent(this, Fei021Activity.class);
            // Bundle bundle = new Bundle();
            // bundle.putString("request_time", "2023年11月1日22:31:45");
            // bundle.putString("request_content", mRequest);
            // intent.putExtras(bundle);

            register.launch(intent); // 传递走
        }
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