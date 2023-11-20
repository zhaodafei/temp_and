package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fei.myfei.service.Fei19_3MyIntentService;
import com.fei.myfei.service.Fei19_3NormalService;

public class Fei19_3Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_normalService, btn_intentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei19_3);

        btn_normalService = findViewById(R.id.fei19_3_btn_normal_service);
        btn_intentService = findViewById(R.id.fei19_3_btn_intent_service);

        btn_normalService.setOnClickListener(this);
        btn_intentService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fei19_3_btn_normal_service) {

            Intent intent = new Intent(Fei19_3Activity.this, Fei19_3NormalService.class);
            startService(intent);
        } else if (v.getId() == R.id.fei19_3_btn_intent_service) {
            Intent intent = new Intent(Fei19_3Activity.this, Fei19_3MyIntentService.class);
            startService(intent);
        }
    }
}