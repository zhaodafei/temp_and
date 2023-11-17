package com.fei.myfei.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {

    private static final String TAG = "Fei18Activity_tag"; // 日志标记

    // 自定义广播名字
    public static final String ALARM_ACTION = "com.fei.myfei.Fei18Activity.alarmFei";

    private final Context myContent;

    public AlarmReceiver(Context myContent) {
        super();
        this.myContent = myContent;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals(ALARM_ACTION)) {
            Log.d(TAG, "onReceive: 收到闹钟广播");
            // sendAlarm(); // 循环调用 =================
        }
    }

    public void sendAlarm() {
        Intent intent = new Intent(ALARM_ACTION);
        // 创建一个用于广播延迟意图
        // 针对 S+(版本10000及更高版本)要求在创建 PendingIntent 时指定 FLAG_IMMUTABLE 或者 FLAG_MUTABLE 之一
        // 强烈考虑使用 FLAG_IMMUTABLE,仅当某些功能依赖于 PendingIntent 是可变的时候才使用 FLAG_MUTABLE
        PendingIntent pendingIntent = PendingIntent.getBroadcast(myContent, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        // 从系统服务中获取闹钟管理器
        AlarmManager alarmManager = (AlarmManager) myContent.getSystemService(Context.ALARM_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 运行在空闲是发送广播,Android6.0 之后新增的方法
            alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, 1000, pendingIntent);
        } else {
            // 设置一次性闹钟,延迟若干秒后,携带延迟意图发送闹钟广播(但Android6.0之后,set方法在暗屏是不保证发送广播
            //      必须调用 setAndAllowWhileIdle 方法)
            alarmManager.set(AlarmManager.RTC_WAKEUP, 1000, pendingIntent);
        }

        // 设置重复闹钟,每隔一定的时间就发送闹钟广播(但是从 Android4.4 开始, setRepeating 方法不保证按时发送广播)
        // alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(), 1000, pendingIntent);

    }
}
