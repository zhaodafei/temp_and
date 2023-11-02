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
import android.widget.Button;
import android.widget.TextView;

public class Fei00MenuActivity extends AppCompatActivity implements View.OnClickListener {

    // private ActivityResultLauncher<Intent> register;

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
                // startActivity(new Intent(Fei00MenuActivity.this, FooActivity.class));

                Intent intent = new Intent();
                intent.setClass(Fei00MenuActivity.this, FooActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("params_fei1", "我是第1个参数");
                bundle.putString("params_fei2", "我是第2个参数");
                intent.putExtras(bundle);
                startActivity(intent); // 注意这个方法,不要选错了,这个方法有多个,参数不一样
            }
        });
        // // 从foo页面返回来拿到数据 ?????????????????/ todo: 从下个页面拿不到数据
        // register = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        //     @Override
        //     public void onActivityResult(ActivityResult result) {
        //         System.out.println("sssssssssss");
        //         Log.d("fei1111111111", "onActivityResult: 收到数据了");
        //     }
        // });

        // 去bar页面
        Button MenuBtn00B = findViewById(R.id.feiMenu00_bar);
        MenuBtn00B.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Fei00MenuActivity.this, BarActivity.class);
                startActivity(intent); // 注意这个方法,不要选错了,这个方法有多个,参数不一样
            }
        });

        // =====================  菜单页面 =============
        findViewById(R.id.feiMenu01_link).setOnClickListener(this); // 第1个页面
        findViewById(R.id.feiMenu02_link).setOnClickListener(this); // 第2个页面
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.feiMenu01_link) {
            // 去第1个页面
            Intent intent = new Intent();
            intent.setClass(Fei00MenuActivity.this, Fei01Activity.class);
            startActivity(intent); // 注意这个方法,不要选错了,这个方法有多个,参数不一样
        } else if (v.getId() == R.id.feiMenu02_link) {
            // 去第2个页面
            Intent intent = new Intent();
            intent.setClass(Fei00MenuActivity.this, Fei02Activity.class);
            startActivity(intent); // 注意这个方法,不要选错了,这个方法有多个,参数不一样
        }
    }

}