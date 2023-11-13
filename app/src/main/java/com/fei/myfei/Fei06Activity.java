package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fei.myfei.entity.UserFei;
import com.fei.myfei.utils.ToastUtils;
import com.fei.myfei.utils.UserDBHelper;

public class Fei06Activity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Fei06Activity_tag"; // 日志标记

    private TextView tv_db;
    private String myDb;
    private UserDBHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei06);

        tv_db = findViewById(R.id.fei06_tv_db);
        findViewById(R.id.fei06_btn_dbCreate).setOnClickListener(this);
        findViewById(R.id.fei06_btn_dbDelete).setOnClickListener(this);
        findViewById(R.id.fei06_btn_insertOne).setOnClickListener(this);

        // 这个文件所在位置  /data/data/com.fei.myfei/files/zzz_fei_SQLite01.db
        // myDb = getFilesDir() + "/zzz_fei_SQLite/test01.db";
        myDb = getFilesDir() + "/zzz_fei_SQLite01.db";
    }

    @Override
    protected void onStart() {
        super.onStart();

        // 打开数据库连接
        mHelper = UserDBHelper.getInstance(this);
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
        String desc = null;
        UserFei userFei = null;

        if (v.getId() == R.id.fei06_btn_dbCreate) {
            // 创建数据库
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
            userFei = new UserFei(1, "大飞");
            if (mHelper.insert(userFei) > 0) {
                //  插入成功
                ToastUtils.show(this,"插入数据成功");
            }

        } else if (v.getId() == R.id.fei06_btn_select) {
            // 读取数据
        }
    }
}