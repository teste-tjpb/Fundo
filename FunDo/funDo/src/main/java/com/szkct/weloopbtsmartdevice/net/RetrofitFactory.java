package com.szkct.weloopbtsmartdevice.net;

import android.util.Log;

import com.szkct.weloopbtsmartdevice.net.RetrofitService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class RetrofitFactory {

    private static final String BASE_URL = "http://wx.funos.cn:8080/fundo/";

    private static final long TIMEOUT = 30;

    // Retrofit is based on OkHttpClient and can create an OkHttpClient for some configuration.
    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            /*
                Here you can add an HttpLoggingInterceptor, because Retrofit encapsulates the request
                from Http to parsing, it is difficult to find out the problem with the bug, add
                HttpLoggingInterceptor interceptor to facilitate debugging interface
             */
            .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.i("[RetrofitFactory]", message);
                }
            }).setLevel(HttpLoggingInterceptor.Level.BASIC))
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build();

    private static RetrofitService retrofitService = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            // Add Gson Converter
            .addConverterFactory(GsonConverterFactory.create())
            // Add Retrofit to RxJava Converter
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
            .create(RetrofitService.class);

    public static RetrofitService getInstance() {
        return retrofitService;
    }
}
