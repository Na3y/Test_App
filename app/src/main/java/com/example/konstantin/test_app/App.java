package com.example.konstantin.test_app;


import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static ProducthuntService producthuntService;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .baseUrl("https://www.producthunt.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        producthuntService = retrofit.create(ProducthuntService.class);

    }

    public static ProducthuntService getApi() {
        return producthuntService;
    }

    ArrayList<Item> items = new ArrayList<Item>();
    PostAdapter postAdapter;


}
