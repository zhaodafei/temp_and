package com.fei.myfei.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class Fei19_3MyIntentService extends IntentService {
    private static final String TAG = "Fei19_3i_Service_tag"; // 日志标记

    /**
     * @param name
     * @deprecated
     */
    public Fei19_3MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "==========IntentService耗时任务开始：" + System.currentTimeMillis());
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
        Log.d(TAG, "============IntentService耗时任务结束");
    }
}
