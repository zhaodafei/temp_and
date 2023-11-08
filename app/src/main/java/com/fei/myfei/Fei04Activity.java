package com.fei.myfei;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Fei04Activity extends AppCompatActivity {

    private final String TAG = "Fei04Activity_webView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fei04);

        findViewById(R.id.fei04_tv1);


        // 简单执行
        // WebView webView = findViewById(R.id.my04_webView);
        // webView.getSettings().setJavaScriptEnabled(true);

        //访问网页
        // webView.loadUrl("http://www.baidu.com");
        // webView.setWebViewClient(new WebViewClient(){
        //
        //     @Override
        //     public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        //         // tip: Android7.0 以后用这个 WebResourceRequest request
        //         //使用WebView加载显示url
        //         view.loadUrl(request.getUrl().toString());
        //         //返回true
        //         return true;
        //     }
        // });


        WebView webView = findViewById(R.id.my04_webView);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //设置自适应屏幕，两者合用
        settings.setUseWideViewPort(true); // 将图片调整到适合webview的大小
        settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        //其他细节操作
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 关闭webview中缓存
        settings.setAllowFileAccess(true); // 设置可以访问文件
        settings.setJavaScriptCanOpenWindowsAutomatically(true); // 支持通过JS打开新窗口
        settings.setLoadsImagesAutomatically(true); // 支持自动加载图片
        settings.setDefaultTextEncodingName("utf-8");// 设置编码格式

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

        // webView.loadUrl("http://www.baidu.com");
        // webView.loadUrl("https://developer.android.google.cn/docs?hl=zh-cn");
        webView.loadUrl("https://support.github.com/features/rest-api");

    }
}