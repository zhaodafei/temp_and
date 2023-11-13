package com.fei.myfei.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    // 消息提醒
    public static void show(Context ctx, String desc) {
        Toast.makeText(ctx,desc,Toast.LENGTH_SHORT).show();
    }
}
