package com.fei.myfei.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fei.myfei.R;

public class Demo01HomeFragment extends Fragment {
    private static final String TAG = "Demo01HomeFragment_tag"; // 日志标记


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: 执行了");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_demo01_fragment_home, container, false);
    }
}
