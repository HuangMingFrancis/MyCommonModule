package com.francis.commonmodule.net;

import com.francis.commonmodule.net.okhttp.LogInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Francis on 2018/10/10.
 * 网络请求管理类
 */

public class NetWorkManager {

    private static Retrofit.Builder builder;
    private static OkHttpClient okHttpClient;

    public static NetWorkManager getInstance(){
        return NetWorkManagerHolder.netWorkManager;
    }

    public void init(){
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())
                .build();
        builder = new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

    }

    public Retrofit getRetrofit(String url){
        builder.baseUrl(url);
        return builder.build();
    }


    public static class NetWorkManagerHolder{
        public static NetWorkManager netWorkManager = new NetWorkManager();
    }

}
