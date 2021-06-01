package com.tsn.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient(); //实例化OkHttpClient
        Request request=new Request.Builder() //创建一个请求对象
                .url(address)
                .build();
        //开启一个异步请求
        client.newCall(request).enqueue(callback);
    }
}
