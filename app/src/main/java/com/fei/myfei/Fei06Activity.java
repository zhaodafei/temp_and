package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fei.myfei.entity.UserFei;
import com.fei.myfei.utils.ToastUtils;
import com.fei.myfei.utils.UserDBHelper;

import java.util.List;

public class Fei06Activity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Fei06Activity_tag"; // 日志标记

    private String myDb;
    private UserDBHelper mHelper;

    private TextView tv_db;
    private EditText et_name;
    private EditText et_age;
    private EditText et_height;
    private EditText et_weight;
    private CheckBox ck_agree;

    private ListView lvData; // 显示查询数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei06);

        tv_db = findViewById(R.id.fei06_tv_db);
        findViewById(R.id.fei06_btn_dbCreate).setOnClickListener(this);
        findViewById(R.id.fei06_btn_dbDelete).setOnClickListener(this);

        // ===================================================================
        et_name = findViewById(R.id.fei06_et_name);
        et_age = findViewById(R.id.fei06_et_age);
        et_height = findViewById(R.id.fei06_et_height);
        et_weight = findViewById(R.id.fei06_et_weight);
        ck_agree = findViewById(R.id.fei06_ck_agree);

        findViewById(R.id.fei06_btn_insertOne).setOnClickListener(this);
        findViewById(R.id.fei06_btn_delete).setOnClickListener(this);
        findViewById(R.id.fei06_btn_update).setOnClickListener(this);
        findViewById(R.id.fei06_btn_select).setOnClickListener(this);

        lvData = findViewById(R.id.fei06_list_view);

        // 这是一个单独的操作数据库(按钮: fei06_btn_dbCreate, fei06_btn_dbDelete)
        // 这个文件所在位置  /data/data/com.fei.myfei/files/zzz_fei_SQLite01.db
        // myDb = getFilesDir() + "/zzz_fei_SQLite/test01.db";
        myDb = getFilesDir() + "/zzz_fei_SQLite01.db";
    }

    @Override
    protected void onStart() {
        super.onStart();

        // 获得数据库帮助器的实例(这个是自动创建的数据库)
        mHelper = UserDBHelper.getInstance(this);
        // 打开数据库帮助器的读写连接
        mHelper.openWriteLink();
        mHelper.openReadLink();
    }

    @Override
    protected void onStop() {
        super.onStop();

        // 关闭数据连接
        mHelper.closeLink();
    }

    @Override
    public void onClick(View v) {
        // 准备数据为后面操作做准备
        String desc = null;
        UserFei userFei = null;
        String name = et_name.getText().toString();
        String age = et_age.getText().toString();
        String height = et_height.getText().toString();
        String weight = et_weight.getText().toString();

        if (v.getId() == R.id.fei06_btn_dbCreate) {
            // 创建数据库(手动创建)
            SQLiteDatabase sqLiteDb = openOrCreateDatabase(myDb, Context.MODE_PRIVATE, null);
            desc = String.format("数据库%s创建%s", sqLiteDb.getPath(), (sqLiteDb != null) ? "成功" : "失败");
            tv_db.setText(desc);
        } else if (v.getId() == R.id.fei06_btn_dbDelete) {
            // 删除数据库
            boolean result = deleteDatabase(myDb);
            desc = String.format("数据库%s删除%s", myDb, result ? "成功" : "失败");
            tv_db.setText(desc);
        } else if (v.getId() == R.id.fei06_btn_insertOne) {
            // 插入数据
            userFei = new UserFei(name,
                    Integer.parseInt(age),
                    Long.parseLong(height),
                    Float.parseFloat(weight),
                    ck_agree.isChecked());
            if (mHelper.insert(userFei) > 0) {
                //  插入成功
                ToastUtils.show(this,"插入数据成功");
            }

        } else if (v.getId() == R.id.fei06_btn_delete) {
            if (mHelper.deleteByName(name) > 0) {
                // 删除
                ToastUtils.show(this,"删除成功");
            }

        } else if (v.getId() == R.id.fei06_btn_update) {
            // 更新数据
            userFei = new UserFei(name,
                    Integer.parseInt(age),
                    Long.parseLong(height),
                    Float.parseFloat(weight),
                    ck_agree.isChecked());
            if (mHelper.update(userFei) > 0) {
                // 修改
                ToastUtils.show(this,"修改成功");
            }

        } else if (v.getId() == R.id.fei06_btn_select) {
            // 查询
            List<UserFei> list = mHelper.queryByName(name);

            String[] dataFei;
            int arrLen = 2;
            dataFei = new String[arrLen];
            int i = 0;
            for (UserFei u : list) {
                Log.d(TAG, u.toString());

                if (i < arrLen) {
                    dataFei[i] = u.name;
                }
                i++;
            }

            ToastUtils.show(this,"读取数据OK");
            inflateList(dataFei);
        }
    }

    public void inflateList(String[] args) {
        // 参考: java/com/fei/myfei/Fei08Activity.java

        // 1、准备数据: waring: 这个ArrayAdapter 监听有点问题
        // String[] data = {"葡萄", "苹果"};
        String[] data = args;
        // 2、数据源
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Fei06Activity.this, android.R.layout.simple_list_item_1, data);
        // 3、将适配器加载到控件中
        lvData.setAdapter(adapter);
        // // 4、为列表中选中的项添加单击响应事件
        // lvData.setOnItemClickListener(this);
    }
}