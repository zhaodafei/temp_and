package com.fei.myfei.api;


import com.fei.myfei.bean.APIDemo04Bean;
import com.fei.myfei.bean.APIDemo04_2Bean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface  ApiService {
    // 真正完整的请求为: http://192.168.20.60:84/api/foo/da
    // 注解里传入网络请求的部分URL 地址
    // Retrofit 把网络请求的 URL 分成了两部分：一部分放在 Retrofit 对象里，另一部分放在网络请求接口里
    // 如果接口里的url是一个完整的网址，那么放在Retrofit对象里的URL可以忽略
    // getDataFei()是接受网络请求数据的方法
    // 这是GET请求的相对路径。它指定了在基本URL之后所附加的路径，以构建完整的请求URL。例如，如果基本URL为
    // https://192.168.20.60:84/，那么最终的请求URL将是 https://192.168.20.60:84/get
    @GET("/api/foo/da")
    Call<APIDemo04Bean> getDataFei();

    // 注意get请求用@Query注解标注请求参数
    // @GET("get")
    // Call<ResponseBody> get(@Query("username") String username, @Query("password") String password);

    // ======================= 另一个在线测试的网站bilibili ========================================
    // https://message.bilibili.com/api/tooltip/query.list.do
    @GET("api/tooltip/query.list.do")
    Call<APIDemo04_2Bean> getBiLiDataFei();   // 将Call当中的泛型类型改为想要返回的javaBean类型
}


