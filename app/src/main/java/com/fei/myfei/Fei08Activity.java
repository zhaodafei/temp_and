package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.fei.myfei.dao.BookInfoDao;
import com.fei.myfei.entity.BookInfo;
import com.fei.myfei.utils.ToastUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Fei08Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private static final String TAG = "Fei08Activity_tag"; // 日志标记

    private BookInfoDao bookInfoDao;
    private ListView lvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei08);

        findViewById(R.id.fei08_btn_insert).setOnClickListener(this);
        findViewById(R.id.fei08_btn_query).setOnClickListener(this);
        findViewById(R.id.fei08_btn_findName).setOnClickListener(this);
        findViewById(R.id.fei08_btn_findId).setOnClickListener(this);

        // 从APP实例中获取唯一的书籍持久化对象
        bookInfoDao = MyApplication.getInstance().getBookInfoDatabase().bookInfoDao();

        lvData = (ListView) findViewById(R.id.fei08_lv_data);
        //3、准备数据: waring: 这个ArrayAdapter 监听有点问题
        String[] data = {"葡萄", "苹果"};
        //4、创建适配器 连接数据源和控件的桥梁
        //参数 1：当前的上下文环境
        //参数 2：当前列表项所加载的布局文件
        //(android.R.layout.simple_list_item_1)这里的布局文件是Android内置的，里面只有一个textview控件用来显示简单的文本内容
        //参数 3：数据源
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Fei08Activity.this, android.R.layout.simple_list_item_1, data);
        //5、将适配器加载到控件中
        lvData.setAdapter(adapter);
        //6、为列表中选中的项添加单击响应事件
        lvData.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fei08_btn_insert) {
            // 添加一条数据到数据库中
            BookInfo b1 = new BookInfo();
            b1.setName("论语");
            b1.setAuthor("孔子");
            b1.setAddress("北京出版社");
            b1.setPrice("2");
            bookInfoDao.insert(b1);

            ToastUtils.show(this, "插入数据成功");

        } else if (v.getId() == R.id.fei08_btn_query) {
            List<BookInfo> list = bookInfoDao.queryAll();
            for (BookInfo bOne : list) {
                Log.d(TAG, bOne.toString());
            }
            ToastUtils.show(this, "控制台查看数据");

        } else if (v.getId() == R.id.fei08_btn_findName) {
            BookInfo nameData = bookInfoDao.queryByName("论语111");
            ToastUtils.show(this, "开发中");

        } else if (v.getId() == R.id.fei08_btn_findId) {
            BookInfo idData = bookInfoDao.queryById("2");
            List list = Collections.synchronizedList(new ArrayList<>());
            list.add(idData.getName()); // 赋值到页面上
            ArrayAdapter<String> adapter = new ArrayAdapter<>(Fei08Activity.this, android.R.layout.simple_list_item_1, list);
            // 5、将适配器加载到控件中
            lvData.setAdapter(adapter);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        // adapterView.getId() 这个可以找到父级
        if (adapterView.getId() == R.id.fei08_lv_data) {
            String result = ((TextView) view).getText().toString();

            ToastUtils.show(this, "您选择的水果是" + result);
        } else {
            Log.d(TAG, "!!!没有触发!!!");
        }
    }
}