package com.fei.myfei.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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

import org.json.JSONException;
import org.json.JSONObject;

public class Demo03Activity extends AppCompatActivity  {
    private static final String TAG = "Demo03Activity_webView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo03);


        WebView webView = findViewById(R.id.demo03_webView);
        WebSettings settings = webView.getSettings();
        // 运行运行js
        settings.setJavaScriptEnabled(true);
        // // 允许运行Dom缓存数据(比如js的: localStorage.setItem("key_fei","value_fei"))
        settings.setDomStorageEnabled(true);

        //设置自适应屏幕，两者合用
        settings.setUseWideViewPort(true); // 将图片调整到适合webview的大小
        settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        //其他细节操作
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 关闭webview中缓存
        settings.setAllowFileAccess(true); // 设置可以访问文件
        settings.setJavaScriptCanOpenWindowsAutomatically(true); // 支持通过JS打开新窗口
        settings.setLoadsImagesAutomatically(true); // 支持自动加载图片
        settings.setDefaultTextEncodingName("utf-8");// 设置编码格式

        // ===== 给HTML中js 一个变量名字 androidFei ====
        webView.addJavascriptInterface(Demo03Activity.this, "androidFei");

        webView.setWebViewClient(new WebViewClient() {

            /* @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String url) {
                Log.e(TAG , "执行_ shouldOverrideUrlLoading  " + url);

                webView.loadUrl(url);
                return true;
            } */
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                // tip: Android7.0 以后用这个 WebResourceRequest request
                // 使用 WebView 加载显示 url
                view.loadUrl(request.getUrl().toString());
                // 返回true
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.e(TAG , "执行__加载开始  " + url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.e(TAG , "执行__加载完成  " + url);

                // ============= 安卓调用html中js =============
                webView.post(new Runnable() {
                    @Override
                    public void run() {
                        webView.evaluateJavascript("javascript:callJsFunction('hello js')", new ValueCallback<String>() {
                            @Override
                            public void onReceiveValue(String s) {
                                Log.d(TAG, "js返回的结果: " + s);
                            }
                        });
                    }
                });
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                Log.e(TAG , "执行__加载资源  " + url);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(webView, request, error);
                Log.e(TAG,"执行__错误了");
            }
        });

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                super.onConsoleMessage(consoleMessage);
                Log.e(TAG , "执行__输出js中的console.log 的内容  " + consoleMessage.message());
                return true;
            }
        });

        // 嵌入一个本地的页面 app/src/main/assets/fei_index.html
        webView.loadUrl("file:///android_asset/fei_index.html");
    }

    // HTML中js调用,无参数
    @JavascriptInterface
    public void saveFei() {
        System.out.println(TAG + "andFei: 安卓我收到了vue中请求了");
        Log.d(TAG, "andFei: 安卓我接受到HTML中的值了");
    }

    // HTML中js调用,参数为一个普通字符串
    @JavascriptInterface
    public void saveFeiArgs(String json) throws JSONException {
        Log.d(TAG, "andFei: 安卓我接受到HTML中的值了" + json);

        JSONObject jsonObject = new JSONObject(json);
        String name = jsonObject.getString("name");
        String age = jsonObject.getString("age");

        Log.d(TAG, "andFei: 安卓我接受到HTML中的值了: " + name);
        Log.d(TAG, "andFei: 安卓我接受到HTML中的值了: " + age);
    }
}