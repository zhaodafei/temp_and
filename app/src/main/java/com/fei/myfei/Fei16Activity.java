package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import com.fei.myfei.receiver.OrderA1Receiver;
import com.fei.myfei.receiver.OrderA2Receiver;


public class Fei16Activity extends AppCompatActivity implements View.OnClickListener {

    // 自定义广播名字
    public static final String ORDER_ACTION = "com.fei.myfei.Fei16Activity.order";

    private OrderA1Receiver a1Receiver;
    private OrderA2Receiver a2Receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei16);

        findViewById(R.id.fei16_btn_send_order).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // 创建一个指定动作的意图
        Intent intent = new Intent(ORDER_ACTION);
        // 发送有序广播
        sendOrderedBroadcast(intent,null);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // 多个接收器处理有序广播的顺序规则为如下:
        // 1. 优先级,越大的接收器,越早接受到有序广播
        // 2. 优先级相同的时候,越早注册的接收器越早收到有序广播
        a1Receiver = new OrderA1Receiver();
        IntentFilter filterA1 = new IntentFilter(ORDER_ACTION);
        filterA1.setPriority(6);
        registerReceiver(a1Receiver, filterA1);

        a2Receiver = new OrderA2Receiver();
        IntentFilter filterA2 = new IntentFilter(ORDER_ACTION);
        filterA2.setPriority(8);
        registerReceiver(a2Receiver, filterA2);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 注销接受器,注销之后就不再接受广播
        unregisterReceiver(a1Receiver);
        unregisterReceiver(a2Receiver);
    }
}