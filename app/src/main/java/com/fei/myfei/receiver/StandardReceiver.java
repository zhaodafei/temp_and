package com.fei.myfei.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class StandardReceiver extends BroadcastReceiver {

    private static final String TAG = "Fei15Activity_OrderReceiver_tag"; // 日志标记

    // 自定义广播名字
    public static final String STANDARD_ACTION = "com.fei.myfei.Fei16Activity.order";


    // 一单接受到标准广播,马上触发接受器的 onReceive 方法
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals(STANDARD_ACTION)) {
            Log.d(TAG, "onReceive: 接受到一个标准广播");
        }
    }
}
