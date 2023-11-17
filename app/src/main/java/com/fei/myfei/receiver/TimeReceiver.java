package com.fei.myfei.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.fei.myfei.utils.ToastUtils;

public class TimeReceiver extends BroadcastReceiver {

    private static final String TAG = "Fei17Activity_tag"; // 日志标记

    @Override
    public void onReceive(Context context, Intent intent) {
        // if (intent != null && intent.getAction().equals(Intent.ACTION_TIME_TICK)) {
        //     Log.d(TAG, "onReceive: 接受到一个时间广播");
        // }

        if (intent != null) {
            Log.d(TAG, "onReceive: 接受到一个分钟到达广播");
            ToastUtils.show(context,"每分钟会受到一个广播");
        }
    }
}
