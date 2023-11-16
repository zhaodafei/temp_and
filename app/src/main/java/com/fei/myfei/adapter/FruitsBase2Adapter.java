package com.fei.myfei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fei.myfei.R;
import com.fei.myfei.bean.Fruits;
import com.fei.myfei.utils.ToastUtils;

import java.util.List;

// 水果
public class FruitsBase2Adapter extends BaseAdapter {

    private Context myContext;
    private List<Fruits> myFruitsList;

    public FruitsBase2Adapter(Context myContext, List<Fruits> myFruitsList) {
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
        ViewHolder holder;
        if (view == null) {
            // 根据布局文件 res/layout/activity_fei10_item_simple3.xml 生成转化视图对象
            view = LayoutInflater.from(myContext).inflate(R.layout.activity_fei10_item_simple3, null);
            holder = new ViewHolder();
            holder.ll_item = view.findViewById(R.id.fei10_3_ll_item); // 控制点击事件的传递

            holder.iv_icon = view.findViewById(R.id.fei10_3_iv_icon01);
            holder.tv_title = view.findViewById(R.id.fei10_3_tv_title01);
            holder.tv_content = view.findViewById(R.id.fei10_3_tv_content01);
            holder.btn_operation = view.findViewById(R.id.fei10_3_btn_operation);
            // 将视图持有者保存到转换视图当中
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }


        // 给控件设置数据
        Fruits fruits = myFruitsList.get(i);
        //  FOCUS_BLOCK_DESCENDANTS 可以阻止下级控件获得焦点,避免堵塞列表视图的点击事件
        holder.ll_item.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS); // 控制点击事件的传递

        holder.iv_icon.setImageResource(fruits.image);
        holder.tv_title.setText(fruits.name);
        holder.tv_content.setText(fruits.desc);
        holder.btn_operation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.show(myContext, "【单独按钮】: 水果: " + fruits.name + " 按钮被点击了");
            }
        });

        return view;
    }

    public static final class ViewHolder{
        public LinearLayout ll_item; // 控制点击事件的传递

        public ImageView iv_icon;
        public TextView tv_title;
        public TextView tv_content;
        public Button btn_operation;
    }
}
