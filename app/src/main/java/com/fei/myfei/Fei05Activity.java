package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Fei05Activity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Fei05Activity_tag"; // 日志标记

    private EditText et_name;
    private EditText et_age;
    private EditText et_height;
    private EditText et_weight;
    private CheckBox ck_agree;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei05);

        et_name = findViewById(R.id.fei05_et_name);
        et_age = findViewById(R.id.fei05_et_age);
        et_height = findViewById(R.id.fei05_et_height);
        et_weight = findViewById(R.id.fei05_et_weight);
        ck_agree = findViewById(R.id.fei05_ck_agree);

        findViewById(R.id.fei05_btn_save).setOnClickListener(this);


        preferences = getSharedPreferences("config", Context.MODE_PRIVATE);
        reload();
    }

    private void reload() {
        Log.d(TAG, "reload: 我这里从 getSharedPreferences 中获取到数据了");
        String name = preferences.getString("name", null);
        if (name != null) {
            et_name.setText(name);
        }

        int age = preferences.getInt("age", 0);
        if (age != 0) {
            et_age.setText(String.valueOf(age));
        }

        float height = preferences.getFloat("height", 0f);
        if (height != 0f) {
            et_height.setText(String.valueOf(height));
        }

        float weight = preferences.getFloat("weight", 0f);
        if (weight != 0f) {
            et_weight.setText(String.valueOf(weight));
        }

        boolean agree = preferences.getBoolean("agree", false);
        ck_agree.setChecked(agree);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fei05_btn_save) {
            String name = et_name.getText().toString();
            String age = et_age.getText().toString();
            String height = et_height.getText().toString();
            String weight = et_weight.getText().toString();

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("name", name);
            editor.putInt("age", Integer.parseInt(age));
            editor.putFloat("height", Float.parseFloat(height));
            editor.putFloat("weight", Float.parseFloat(weight));
            editor.putBoolean("agree", ck_agree.isChecked());
            editor.commit();

        }
    }
}