package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import com.fei.myfei.adapter.FruitsBase2Adapter;
import com.fei.myfei.adapter.FruitsBaseAdapter;
import com.fei.myfei.bean.Fruits;
import com.fei.myfei.utils.ToastUtils;
import com.fei.myfei.utils.UnitUtils;

import java.util.List;

public class Fei10Activity extends AppCompatActivity implements AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener {

    private ListView  lvList;
    private List<Fruits>  fruitsList;
    private CheckBox ck_line;
    private CheckBox ck_bg;

    private ListView  lvList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei10);

        // ListView 数据
        lvList = findViewById(R.id.fei10_lv01);
        fruitsList = Fruits.getDefaltList();
        FruitsBaseAdapter adapter = new FruitsBaseAdapter(this, fruitsList);
        lvList.setAdapter(adapter);
        lvList.setOnItemClickListener(this);

        // 复选框操作
        ck_line = findViewById(R.id.fei10_ck_line);
        ck_line.setOnCheckedChangeListener(this);
        ck_bg = findViewById(R.id.fei10_ck_bg);
        ck_bg.setOnCheckedChangeListener(this);

        // ListView2 数据 ================= 添加了btn按钮 ===================================
        lvList2 = findViewById(R.id.fei10_lv02);
        // fruitsList = Fruits.getDefaltList(); // 这个可以共用上面的
        FruitsBase2Adapter adapter2 = new FruitsBase2Adapter(this, fruitsList);
        lvList2.setAdapter(adapter2);
        lvList2.setOnItemClickListener(this);
    }

    // ListView 数据
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.fei10_lv01) {
            ToastUtils.show(this, "ListView 您选择的水果是" + fruitsList.get(i).name);
        } else if (adapterView.getId() == R.id.fei10_lv02) {
            ToastUtils.show(this, "ListView222 您选择的【水果】是" + fruitsList.get(i).name);
        }
    }

    // 复选框操作
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (compoundButton.getId() == R.id.fei10_ck_line) {
            // 显示分割线
            if (ck_line.isChecked()) {
                Drawable drawable = getResources().getDrawable(R.color.black, getTheme());
                lvList.setDivider(drawable);
                lvList.setDividerHeight(UnitUtils.dip2px(this, 2));
            } else {
                lvList.setDivider(null);
                lvList.setDividerHeight(0);
            }
        } else if (compoundButton.getId() == R.id.fei10_ck_bg) {
            // 显示按压背景
            if (ck_bg.isChecked()) {
                lvList.setSelector(R.drawable.list_selector);
            } else {
                Drawable drawable = getResources().getDrawable(R.color.black, getTheme());
                lvList.setSelector(drawable);
            }
        }
    }
}