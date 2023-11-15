package com.fei.myfei;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.fei.myfei.database.BookInfoDatabase;

import java.util.HashMap;

public class MyApplication extends Application {

    private static final String TAG = "MyApplication_fei_tag"; // 日志标记
    private static MyApplication myApp; // 全局使用
    // 声明一个公共的信息映射对象,当做全局变量使用
    public HashMap<String, String> infoMap = new HashMap<>();

    // 声明一个书籍数据库对象
    private BookInfoDatabase bookInfoDatabase;

    public static MyApplication getInstance() {
        return myApp;
    }

    // APP 启动点额时候调用
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: 应用开始启动了");
        myApp = this; // 赋值全局对象

        // 图书(第三个参数是数据库名字)
        bookInfoDatabase = Room.databaseBuilder(this, BookInfoDatabase.class, "db_fei_book")
                .addMigrations()  // 允许迁移数据库
                .allowMainThreadQueries()  // 允许在主线程中操作数据(不建议这样做)
                .build();
    }

    // APP 终止时调用(一般用不到)
    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "onTerminate: 应用终止了!!! ");
    }

    // 配置改变了,比如屏幕旋转
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: 程序发生了改变");
    }

    // 获取数据实例
    public BookInfoDatabase getBookInfoDatabase() {
        return bookInfoDatabase;
    }
}
