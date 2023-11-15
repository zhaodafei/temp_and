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
        findViewById(R.id.feiMenu03_link).setOnClickListener(this); // 第3个页面
        findViewById(R.id.feiMenu04_link).setOnClickListener(this); // 第4个页面
        findViewById(R.id.feiMenu05_link).setOnClickListener(this); // 第5个页面
        findViewById(R.id.feiMenu06_link).setOnClickListener(this); // 第6个页面
        findViewById(R.id.feiMenu07_link).setOnClickListener(this); // 第7个页面
        findViewById(R.id.feiMenu08_link).setOnClickListener(this); // 第8个页面
        findViewById(R.id.feiMenu09_link).setOnClickListener(this); // 第9个页面
        findViewById(R.id.feiMenu10_link).setOnClickListener(this); // 第10个页面
        findViewById(R.id.feiMenu11_link).setOnClickListener(this); // 第11个页面
        findViewById(R.id.feiMenu12_link).setOnClickListener(this); // 第12个页面
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
        } else if (v.getId() == R.id.feiMenu03_link) {
            // 去第3个页面
            Intent intent = new Intent();
            intent.setClass(Fei00MenuActivity.this, Fei03Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.feiMenu04_link) {
            // 去第4个页面
            Intent intent = new Intent();
            intent.setClass(Fei00MenuActivity.this, Fei04Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.feiMenu05_link) {
            Intent intent = new Intent();
            intent.setClass(Fei00MenuActivity.this, Fei05Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.feiMenu06_link) {
            Intent intent = new Intent();
            intent.setClass(Fei00MenuActivity.this, Fei06Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.feiMenu07_link) {
            Intent intent = new Intent();
            intent.setClass(Fei00MenuActivity.this, Fei07Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.feiMenu08_link) {
            Intent intent = new Intent();
            intent.setClass(Fei00MenuActivity.this, Fei08Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.feiMenu09_link) {
            Intent intent = new Intent();
            intent.setClass(Fei00MenuActivity.this, Fei09Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.feiMenu10_link) {
            Intent intent = new Intent();
            intent.setClass(Fei00MenuActivity.this, Fei10Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.feiMenu11_link) {
            Intent intent = new Intent();
            intent.setClass(Fei00MenuActivity.this, Fei11Activity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.feiMenu12_link) {
            Intent intent = new Intent();
            intent.setClass(Fei00MenuActivity.this, Fei12Activity.class);
            startActivity(intent);
        }
    }

}