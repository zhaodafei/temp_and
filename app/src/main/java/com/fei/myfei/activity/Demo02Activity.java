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

public class Demo02Activity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup rg_tabMenu;
    private Demo01HomeFragment homePage;
    private Demo01MyFragment myPage;
    private Button btn_select_ProvinceCityCounty;
    private TextView btn_select_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo02);

        btn_select_ProvinceCityCounty = findViewById(R.id.demo02_btn);
        btn_select_show = findViewById(R.id.demo02_tv_show);
        btn_select_ProvinceCityCounty.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.demo02_btn) {
            AddressPicker picker = new AddressPicker(this);
            picker.setAddressMode(AddressMode.PROVINCE_CITY_COUNTY);
            picker.setTitle("北京市北京市西城区");
            picker.setDefaultValue("北京市", "北京市", "西城区");
            LinkageWheelLayout wheelLayout = picker.getWheelLayout();
            wheelLayout.setOnLinkageSelectedListener(new OnLinkageSelectedListener() {
                @Override
                public void onLinkageSelected(Object first, Object second, Object third) {
                    picker.getTitleView().setText(String.format("%s%s%s",
                            picker.getProvinceWheelView().formatItem(first),
                            picker.getCityWheelView().formatItem(second),
                            picker.getCountyWheelView().formatItem(third)));
                }
            });
            TextView okView = picker.getOkView();
            okView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 关闭的时候,从title中拿到数据回显
                    btn_select_show.setText(picker.getTitleView().getText());
                    picker.dismiss();
                }
            });
            picker.show();
        }
    }
}