package com.fei.myfei.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fei.myfei.R;
import com.fei.myfei.api.ApiService;
import com.fei.myfei.bean.APIDemo04Bean;
import com.fei.myfei.bean.APIDemo04_2Bean;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Demo04Activity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Demo04Activity";

    private TextView tv_setData;
    private TextView tv_setJsonData;
    private Button btn_url;
    private Button btn_url2;
    private Button btn_url3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo04);

        tv_setData = findViewById(R.id.demo04_tv_setData);
        tv_setJsonData = findViewById(R.id.demo04_tv_setJsonData);

        // 本地接口: http://192.168.20.60:84/api/foo/da
        // 在线接口: https://message.bilibili.com/api/tooltip/query.list.do
        btn_url = findViewById(R.id.demo04_btn_get1);
        btn_url.setOnClickListener(this);

        btn_url2 = findViewById(R.id.demo04_btn_get2);
        btn_url2.setOnClickListener(this);

        btn_url3 = findViewById(R.id.demo04_btn_get3);
        btn_url3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.demo04_btn_get1) {
            Log.d(TAG, "onClick: 网路请求了");


            // 用OkHttp
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://192.168.20.60:84/api/foo/da")
                    .build();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 请求网络，通过client新建请求，传入request对象。execute执行
                        Response response = client.newCall(request).execute();
                        setData("OkHttpClient 网络请求成功了");

                        // 接口: http://192.168.20.60:84/api/foo/da
                        // 返回JSON数据格式: {"error":10000,"msg":"1111111","data":[],"page_count":0}
                        // response.body().string()获取返回的json，可以通过 fastjson 工具的方法将json解析成Model对象
                        Log.d(TAG, "run: " + response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                // 运行子线程
            }).start();

        } else if (v.getId() == R.id.demo04_btn_get2) {
            // 参考地址: https://www.cnblogs.com/luqman/p/okhttp_retrofit.html

            //步骤1:创建Retrofit对象
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.20.60:84/")  // 设置 网络请求 Url
                    .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                    .build();

            // 步骤2:创建 网络请求接口 的实例
            ApiService request = retrofit.create(ApiService.class);
            Call<APIDemo04Bean> call = request.getDataFei();
            call.enqueue(new Callback<APIDemo04Bean>() {
                @Override
                public void onResponse(Call<APIDemo04Bean> call, retrofit2.Response<APIDemo04Bean> response) {
                    // 请求成功时回调
                    // 步骤7：处理返回的数据结果
                    Log.d(TAG, "onResponse: 请求成功");
                    setData("Retrofit 本地api网络请求成功了");

                    setJsonData("这里待处理JSON数据11");

                    APIDemo04Bean bean = response.body();
                    Log.d(TAG, "请求返回数据为" + bean);
                }

                @Override
                public void onFailure(Call<APIDemo04Bean> call, Throwable t) {
                    //请求失败时回调
                    Log.d(TAG, "onFailure: 连接失败");
                }
            });
        } else if (v.getId() == R.id.demo04_btn_get3) {

            //步骤1:创建Retrofit对象
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://message.bilibili.com/api/")  // 设置 网络请求 Url
                    .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                    .build();
            // 步骤2:创建 网络请求接口 的实例
            ApiService biliRequest = retrofit.create(ApiService.class);
            Call<APIDemo04_2Bean> biLiDataFei = biliRequest.getBiLiDataFei();
            biLiDataFei.enqueue(new Callback<APIDemo04_2Bean>() {
                @Override
                public void onResponse(Call<APIDemo04_2Bean> call, retrofit2.Response<APIDemo04_2Bean> response) {
                    // 请求成功时回调
                    // 步骤7：处理返回的数据结果
                    Log.d(TAG, "bili 请求成功");
                    setData("Retrofit 在线api网络bili成功了");
                    setJsonData("这里待处理JSON数据22");

                    APIDemo04_2Bean body = response.body();
                    Log.d(TAG, "bili 请求返回数据为" + body);
                }

                @Override
                public void onFailure(Call<APIDemo04_2Bean> call, Throwable t) {
                    //请求失败时回调
                    Log.d(TAG, "bili 连接失败");
                }
            });
        }
    }

    // 接口请求成功后,给页面赋值
    private void setData(String str) {
        // 创建UI线程，修改UI页面是主线程操作，不可在子线程运行
        // 在 Fragment 碎片中要 getActivity().runOnUiThread 这样使用
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在UI线程中展示获取到的数据
                tv_setData.setText(str);
            }
        });
    }

    // 接口请求成功后,给页面赋值接口中的JSON数据
    private void setJsonData(String str) {
        // 创建UI线程，修改UI页面是主线程操作，不可在子线程运行
        // 在 Fragment 碎片中要 getActivity().runOnUiThread 这样使用
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在UI线程中展示获取到的数据
                tv_setJsonData.setText(str);
            }
        });
    }
}