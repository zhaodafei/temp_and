package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.fei.myfei.adapter.FruitsGridAdapter;
import com.fei.myfei.bean.Fruits;
import com.fei.myfei.utils.ToastUtils;

import java.util.List;

public class Fei11Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView gv01;
    private List<Fruits> fruitsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei11);

        gv01 = findViewById(R.id.fei11_gv01);
        fruitsList = Fruits.getDefaltList();

        FruitsGridAdapter adapter = new FruitsGridAdapter(this, fruitsList);
        gv01.setAdapter(adapter);
        gv01.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.fei11_gv01) {
            ToastUtils.show(this, "ListView 您选择的水果是" + fruitsList.get(i).name);
        }
    }
}