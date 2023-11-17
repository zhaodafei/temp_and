package com.fei.myfei.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fei.myfei.R;


public class Fei13StaticFragment extends Fragment {

    private static final String TAG = "Fei13StaticFragment_tag"; // 日志标记

    // 用这个关联上模板(activity_fei13_static_fragment)就可以看到页面了
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: 执行了");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_fei13_static_fragment, container, false);
    }

    // 把碎片贴到页面上
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: 执行了 111111111");
    }

    // 页面创建
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: 执行了 2222222222");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: 执行了444444444");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: 执行了5555555555555");
    }
}