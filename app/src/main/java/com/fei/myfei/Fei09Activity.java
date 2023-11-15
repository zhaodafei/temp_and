package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.fei.myfei.adapter.FruitsBaseAdapter;
import com.fei.myfei.bean.Fruits;
import com.fei.myfei.utils.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Fei09Activity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {

    private static final String TAG = "Fei09Activity_tag"; // 日志标记

    private static final int[] iconArray = {
            R.drawable.food_apple, R.drawable.food_dish, R.drawable.food_grape,
            R.drawable.food_mug, R.drawable.food_pear,
    };
    private static final String[] bookArray = {"论语", "史记", "左传", "汉书", "战国策"};
    private Spinner sp_dropdown;
    private Spinner sp_dialog;
    private Spinner sp_simpleAdapter;
    private Spinner sp_simpleAdapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei09);

        // ===== 下拉框形式 =============
        sp_dropdown = findViewById(R.id.fei09_sp_dropdown);
        // 声明一个下拉列表的数组适配器 R.layout.activity_fei09_item_select 用这个自定义的模板 res/layout/activity_fei09_item_select.xml
        ArrayAdapter<String> bookAdapter = new ArrayAdapter<>(this, R.layout.activity_fei09_item_select, bookArray);
        sp_dropdown.setAdapter(bookAdapter);
        sp_dropdown.setSelection(0); // 默认选中第一项
        sp_dropdown.setOnItemSelectedListener(this); // 给下拉框设置监听器,用户选择某一项后触发

        // ===== 弹窗形式 =============
        sp_dialog = findViewById(R.id.fei09_sp_dialog);
        ArrayAdapter<String> bookAdapter2 = new ArrayAdapter<>(this, R.layout.activity_fei09_item_dialog, bookArray);
        sp_dialog.setPrompt("请选择"); // dialog 模式下才会有
        sp_dialog.setAdapter(bookAdapter2);
        sp_dialog.setSelection(0); // 默认选中第一项
        sp_dialog.setOnItemSelectedListener(this); // 给下拉框设置监听器,用户选择某一项后触发

        // ===== 下拉框,simpleAdapter =============
        sp_simpleAdapter = findViewById(R.id.fei09_sp_simpleAdapter);

        // 构建数据结构
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < iconArray.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("icon", iconArray[i]);
            item.put("name", bookArray[i]);
            list.add(item);
        }

        // 声明一个下拉列表简单适配器,其中指定了图标与文本两组数据
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.activity_fei09_item_simple,
                new String[]{"icon", "name"},
                new int[]{R.id.fei09_iv_icon01, R.id.fei09_tv_name01}
        );

        sp_simpleAdapter.setAdapter(simpleAdapter);
        sp_simpleAdapter.setSelection(0); // 默认选中0
        sp_simpleAdapter.setOnItemSelectedListener(this); // 默认选中0

        // ===== 下拉框,simpleAdapter 2号=============
        sp_simpleAdapter2 = findViewById(R.id.fei09_sp_simpleAdapter2);
        List<Fruits> fruitsList = Fruits.getDefaltList(); // 获取默认的水果列表
        FruitsBaseAdapter simpleAdapter2 = new FruitsBaseAdapter(this, fruitsList); // 构建一个水果类别适配器
        sp_simpleAdapter2.setAdapter(simpleAdapter2);
        // sp_simpleAdapter2.setSelection(0);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.fei09_sp_dropdown) {
            String result = ((TextView) view).getText().toString();
            ToastUtils.show(this, "sp_dropdown 您选择的图书是" + result);

        } else if (adapterView.getId() == R.id.fei09_sp_dialog) {
            String result = ((TextView) view).getText().toString();
            ToastUtils.show(this, "sp_dialog 您选择的图书是" + result);

        } else if (adapterView.getId() == R.id.fei09_sp_simpleAdapter) {
            ToastUtils.show(this, "sp_simpleAdapter 您选择的图书是" + bookArray[i]);
        }  else {
            Log.d(TAG, "!!!没有触发!!!");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}