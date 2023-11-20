package com.fei.myfei.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class Fei19_2BindService extends Service {

    private static final String TAG = "Fei19_2_tag"; // 日志标记

    public int count;
    public boolean quit;
    MyBind myBind = new MyBind();

    public class MyBind extends Binder {
        public int getCount() {
            return count;
        }
    }

    //必须实现的方法，绑定该Service时首先回调该方法
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "----onBind：Service is Binded");
        return myBind;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "----onCreate：Service is Created");

        //动态改变count状态值，用于反映Service 的状态
        new Thread(){
            @Override
            public void run() {
                while (!quit) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    count++;
                }
            }
        }.start();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "----onUnbind：Service is Unbind");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.quit = true;
        Log.d(TAG, "----onDestroy：Service is Destroyed");
    }
}
