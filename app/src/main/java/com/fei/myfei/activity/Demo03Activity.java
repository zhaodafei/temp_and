package com.fei.myfei.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fei.myfei.R;
import com.fei.myfei.fragment.Demo01HomeFragment;
import com.fei.myfei.fragment.Demo01MyFragment;
import com.github.gzuliyujiang.wheelpicker.AddressPicker;
import com.github.gzuliyujiang.wheelpicker.annotation.AddressMode;
import com.github.gzuliyujiang.wheelpicker.contract.OnLinkageSelectedListener;
import com.github.gzuliyujiang.wheelpicker.widget.LinkageWheelLayout;

public class Demo03Activity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo03);

    }

}