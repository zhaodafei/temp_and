package com.fei.myfei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fei.myfei.R;
import com.fei.myfei.bean.Fruits;

import java.util.List;

// 水果
public class FruitsBaseAdapter extends BaseAdapter {

    private Context myContext;
    private List<Fruits> myFruitsList;

    public FruitsBaseAdapter(Context myContext, List<Fruits> myFruitsList) {
        this.myContext = myContext;
        this.myFruitsList = myFruitsList;
    }

    // 获取列表项的个数
    @Override
    public int getCount() {
        return myFruitsList.size();
    }

    @Override
    public Object getItem(int i) {
        return myFruitsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // tip-fei: 每次进入这个页面多会创建一次,不太友好
        // // 根据布局文件 res/layout/activity_fei09_item_simple2.xml 生成转化视图对象
        // View view1 = LayoutInflater.from(myContext).inflate(R.layout.activity_fei09_item_simple2,null);
        // ImageView iv_icon = view1.findViewById(R.id.fei09_2_iv_icon01);
        // TextView tv_title = view1.findViewById(R.id.fei09_2_tv_title01);
        // TextView tv_content = view1.findViewById(R.id.fei09_2_tv_content01);
        //
        // // 给控件设置数据
        // Fruits fruits = myFruitsList.get(i);
        // iv_icon.setImageResource(fruits.image);
        // tv_title.setText(fruits.name);
        // tv_content.setText(fruits.desc);
        //
        // return view1;

        ViewHolder holder;
        if (view == null) {
            // 根据布局文件 res/layout/activity_fei09_item_simple2.xml 生成转化视图对象
            view = LayoutInflater.from(myContext).inflate(R.layout.activity_fei09_item_simple2, null);
            holder = new ViewHolder();
            holder.iv_icon = view.findViewById(R.id.fei09_2_iv_icon01);
            holder.tv_title = view.findViewById(R.id.fei09_2_tv_title01);
            holder.tv_content = view.findViewById(R.id.fei09_2_tv_content01);
            // 将视图持有者保存到转换视图当中
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }


        // 给控件设置数据
        Fruits fruits = myFruitsList.get(i);
        holder.iv_icon.setImageResource(fruits.image);
        holder.tv_title.setText(fruits.name);
        holder.tv_content.setText(fruits.desc);

        return view;
    }

    public static final class ViewHolder{
        public ImageView iv_icon;
        public TextView tv_title;
        public TextView tv_content;
    }
}
