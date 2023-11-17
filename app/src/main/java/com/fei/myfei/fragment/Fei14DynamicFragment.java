package com.fei.myfei.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fei.myfei.R;


public class Fei14DynamicFragment extends Fragment {

    private static final String TAG = "Fei14DynamicFragment_tag"; // 日志标记

    public static Fei14DynamicFragment newInstance(int position, int image_id, String desc) {
        Fei14DynamicFragment fragment = new Fei14DynamicFragment();
        // 把参数打包,传入 fragment 中
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putInt("image_id", image_id);
        args.putString("desc", desc);
        fragment.setArguments(args);
        return fragment;
    }

    // 创建碎片视图
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 关联布局文件(activity_fei14_dynamic_fragment.xml)生成视图对象,就可以看到页面了
        View view = inflater.inflate(R.layout.activity_fei14_dynamic_fragment, container, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ImageView iv_pic = view.findViewById(R.id.fei14_dynamic_iv_pic);
            TextView tv_desc = view.findViewById(R.id.fei14_dynamic_tv_desc);
            // 第二个参数 R.drawable.ic_icon_fei, 是默认值
            iv_pic.setImageResource(arguments.getInt("image_id", R.drawable.ic_icon_fei));
            tv_desc.setText(arguments.getString("desc", "还没有值,我设置一个默认值"));
        }

        return view;
    }

    // 从包裹取出位置序号
    private int getPosition() {
        return getArguments().getInt("position", 0);
    }

    // 把碎片贴到页面上
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: 位置position是" + getPosition());
    }

    // 页面创建
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: 位置position是" + getPosition());
    }

    // 销毁碎片视图
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: 位置position是" + getPosition());
    }

    // 页面销毁
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: 位置position是" + getPosition());
    }

    // 把碎片从页面撕下来
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: 位置position是" + getPosition());
    }
}