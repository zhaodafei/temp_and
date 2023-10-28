package com.fei.myfei.utils;

import android.content.Context;

/**
 * 单位工具类
 */
public class UnitUtils {

    // 根据手机分辨率从 dp 的单位转为 px(像素)
    public static int dip2px(Context context, float dpVal) {
        // 获取当前手机的像素密度( 1个dp对应介个px )
        float densityScale = context.getResources().getDisplayMetrics().density;

        // 四舍五入取整
        return (int) (dpVal * densityScale + 0.5f);
    }
}
