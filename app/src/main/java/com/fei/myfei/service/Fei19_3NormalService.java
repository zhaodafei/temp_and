package com.fei.myfei.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class Fei19_3NormalService extends Service {
    private static final String TAG = "Fei19_3n_Service_tag"; // 日志标记

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "===NormalService耗时任务开始 "+System.currentTimeMillis());
        long endTime = System.currentTimeMillis() + 20 * 1000;
        if (System.currentTimeMillis() < endTime) {
            synchronized (this) {
                try {
                    //等待20s，模拟耗时操作
                    wait(endTime - System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        Log.d(TAG, "=======NormalService耗时任务结束 ");
        return START_STICKY;
    }
}
