package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fei.myfei.service.Fei19_2BindService;
import com.fei.myfei.utils.ToastUtils;

public class Fei19_2Activity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Fei19_2Activity_tag"; // 日志标记

    private Button btn_bindService, btn_unbindService, btn_getStatus;
    private Intent intent;

    private Fei19_2BindService.MyBind iBinder1;
    private ServiceConnection myConnection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei19_2);

        btn_bindService = findViewById(R.id.fei19_2_bind_service);
        btn_unbindService = findViewById(R.id.fei19_2_unbind_service);
        btn_getStatus = findViewById(R.id.fei19_2_get_status);

        btn_bindService.setOnClickListener(this);
        btn_unbindService.setOnClickListener(this);
        btn_getStatus.setOnClickListener(this);

        myConnection = new ServiceConnection() {
            // 当与service的连接建立后被调用
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                iBinder1 = (Fei19_2BindService.MyBind) iBinder;
                Log.d(TAG, "onServiceConnected: Service is Connected");
            }

            // 当与service的连接意外断开时被调用
            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.d(TAG, "onServiceDisconnected: Service is Disconnected");
            }
        };;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fei19_2_bind_service) {

            // 绑定指定的Service
            intent = new Intent(this, Fei19_2BindService.class);
            bindService(intent, myConnection, Service.BIND_AUTO_CREATE);
            ToastUtils.show(this,"服务已经绑定");
        } else if (v.getId() == R.id.fei19_2_unbind_service) {

            unbindService(myConnection);
            ToastUtils.show(this,"服务已经解绑");
        } else if (v.getId() == R.id.fei19_2_get_status) {

            Log.d(TAG, "Service的count值为：" + iBinder1.getCount());
            ToastUtils.show(this,"Service的count值为"+ iBinder1.getCount());
        }
    }
}