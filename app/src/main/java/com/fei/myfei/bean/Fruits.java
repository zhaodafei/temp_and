package com.fei.myfei.bean;

import android.media.Image;

import com.fei.myfei.R;

import java.util.ArrayList;
import java.util.List;

// 水果
public class Fruits {
    public int image; // 水果图片
    public String name; // 水果描述
    public String desc; // 水果描述

    public Fruits(int image, String name, String desc) {
        this.image = image;
        this.name = name;
        this.desc = desc;
    }

    private static  int[] iconArray = {
            R.drawable.food_apple, R.drawable.food_cherry, R.drawable.food_grape,
            R.drawable.food_orange, R.drawable.food_pear,
    };
    private static  String[] fruitArray = {"苹果", "樱桃", "葡萄", "橘子", "梨"};
    private static String[] descArray = {
            "苹果是一种常见的水果，呈圆形或椭圆形，大小适中，表皮光滑，通常为绿色，也有红色、黄色等其他颜色。",
            "樱桃是一种常见的水果，属于蔷薇科樱属植物。樱桃因其酸甜可口、多汁而受到广泛喜爱",
            "葡萄是一种富含维生素C的水果，可增强免疫力，促进伤口愈合，预防感冒和其他疾病",
            "橘子既不是凉性的也不是热性的,橘子属于温性的水果,一般来讲凉性具有清热泻火、滋阴除蒸的作用,热性具有补火助阳、引火归元的作用,而橘子性温,与热性具有程度上的差异",
            "江苏丰县翠冠梨，丰县翠冠梨的果肉细嫩，汁多酥脆，甜度高，口感非常好。翠冠梨的果皮为绿色，外皮光滑，通常作为生食水果或制作果汁。丰县翠冠梨不" +
                    "仅味道美，而且含有丰富的营养价值，如维生素C、多种矿物质和抗氧化物质",
    };

    public static List<Fruits> getDefaltList() {
        List<Fruits> fruitList = new ArrayList<>();
        for (int i = 0; i < iconArray.length; i++) {
            fruitList.add(new Fruits(iconArray[i], fruitArray[i], descArray[i]));
        }
        return fruitList;
    }
}
