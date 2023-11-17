package com.fei.myfei.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.fei.myfei.utils.ToastUtils;

public class OrderA2Receiver extends BroadcastReceiver {

    private static final String TAG = "Fei16Activity_StandardReceiver_tag"; // 日志标记

    // 自定义广播名字
    public static final String ORDER_ACTION = "com.fei.myfei.Fei16Activity.order";


    // 一单接受到标准广播,马上触发接受器的 onReceive 方法
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals(ORDER_ACTION)) {
            Log.d(TAG, "onReceive:!!!谁是第2名!!!! 接受到222222222222广播");
            ToastUtils.show(context,"222222222222");
            // abortBroadcast(); 中断广播,此时后面的接收器将无法收到广播
        }
    }
}
