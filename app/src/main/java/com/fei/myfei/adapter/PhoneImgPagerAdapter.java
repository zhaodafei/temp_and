package com.fei.myfei.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.fei.myfei.entity.PhoneInfo;

import java.util.ArrayList;
import java.util.List;

public class PhoneImgPagerAdapter extends PagerAdapter {

    private final Context myContext;
    private final ArrayList<PhoneInfo> myPhoneList;
    // 声明一个图像视图列表
    private List<ImageView> myViewList = new ArrayList<>();

    public PhoneImgPagerAdapter(Context myContext, ArrayList<PhoneInfo> myPhoneList) {
        this.myContext = myContext;
        this.myPhoneList = myPhoneList;

        // 给每个手机分配一个专用的图形视图
        for (PhoneInfo info : myPhoneList) {
            ImageView view = new ImageView(myContext);
            view.setLayoutParams(new ViewGroup.LayoutParams(
                    // 设置宽高
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            view.setImageResource(info.pic);
            myViewList.add(view);
        }
    }

    @Override
    public int getCount() {
        return myViewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        // 从下面的方法 instantiateItem 中返回了
        return view == object;
    }

    // 实例化指定位置页面,并将其添加到容器中
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        // 添加一个 view 到 container 中,而后返回一个跟这个 view 可以关联起来的对象
        // 这个对象能够是 view 自身,也能够是其余对象,
        // 关键是在 isViewFromObject 可以将 view 和这个 object 关联起来
        ImageView item = myViewList.get(position);
        container.addView(item);
        return item;
    }

    // 从容器中销毁指定位置的页面
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(myViewList.get(position));
    }

    // 标题栏数据(有标题栏执行,没有不执行)
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return myPhoneList.get(position).name;
    }
}
