package com.daniel.user.charleskeith.data.model;


import android.content.Context;
import android.util.Log;

import com.daniel.user.charleskeith.CharlesAndKeithAPP;
import com.daniel.user.charleskeith.network.responese.CKAPI;
import com.daniel.user.charleskeith.persistencec.dao.ProductsDB;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseModel {
    protected CKAPI mAPI;
    protected ProductsDB productsDB;

    protected BaseModel(Context context) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CharlesAndKeithAPP.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        mAPI = retrofit.create(CKAPI.class);
        productsDB = ProductsDB.getmInstance(context);
        Log.d(CharlesAndKeithAPP.APP_LOG, "Network call finished");

    }
}
