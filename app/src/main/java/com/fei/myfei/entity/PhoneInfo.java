package com.fei.myfei.entity;

import com.fei.myfei.R;
import com.fei.myfei.bean.Fruits;

import java.util.ArrayList;
import java.util.List;

public class PhoneInfo {

    public int id;
    public String name; // 手机名称
    public String description; // 手机描述
    public float price; // 手机价格
    public String picPath; // 大图路径
    public int pic; // 大图资源编号

    // 声明一个手机商品名称数组
    private static String[] myNameArray = {
            "华为Mate30", "华为畅享60X", "RedmiK60", "荣耀90pro", "荣耀magic v2", "iPhone15"
    };

    // 声明一个手机商品描述数组
    private static String[] myDescArray = {
            "HUAWEI Mate 30 5G,电池额定容量为4100mAh",
            "华为畅享 60X,800万像素前置摄像头（f/2.0光圈）,显示屏采用圆角设计，按照标准矩形测量时，屏幕的对角线长度是6.95英寸（实际可视区域略小）",
            "RedmiK60,第二代 1.5K 高亮高刷屏,自研科技狂暴引擎 2.0,LPDDR5X + UFS4.0 旗舰级内存配置",
            "荣耀90pro,FHD+ 2700*1224 像素,使用的内存容量小于此值，因为手机软件占用部分空间",
            "荣耀magic v2,第二代骁龙8 领先版,展开态 长 x 宽 x 厚：156.7 x 145.4 x 4.7 mm；",
            "iPhone15,灵动岛会以醒目方式弹出提醒和实时活动，让你忙起来也不会错过重要消息。叫的车还有多久到，谁打电话来了，航班现在什么状态，都能一眼明了",
    };

    private static float[] myPriceArray = {
            100, 209, 360, 480, 520, 666
    };

    // 声明一个手机大图数组
    private static int[] myPicArray = {
            R.drawable.phone_01, R.drawable.phone_02, R.drawable.phone_03,
            R.drawable.phone_04, R.drawable.phone_05, R.drawable.phone_06,
    };

    // 获取默认手机信息列表
    public static ArrayList<PhoneInfo> getDefaultList() {
        ArrayList<PhoneInfo> phoneList = new ArrayList<>();
        for (int i = 0; i < myNameArray.length; i++) {
            PhoneInfo info = new PhoneInfo();
            info.id = i;
            info.name = myNameArray[i];
            info.description = myDescArray[i];
            info.price = myPriceArray[i];
            info.pic = myPicArray[i];
            phoneList.add(info);
        }
        return phoneList;
    }
}
