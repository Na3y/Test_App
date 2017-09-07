package com.example.konstantin.test_app;

import android.content.Context;

import com.example.konstantin.test_app.POJO.Product;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

class RequestData {

    private ArrayList<Item> items;
    private Context context;
    private String token;

    RequestData(Context context, String token){
        this.context = context;
        this.token = token;
    }

    PostAdapter getAdapter(String category) throws ExecutionException, InterruptedException {
        RequestPosts apiRequest = new RequestPosts(this.context, this.token);
        apiRequest.execute(category);
        items = apiRequest.getItems();
        return apiRequest.get();
    }

    ArrayList<Item> getItems(){
        return this.items;
    }

    Product getProduct(String id) throws ExecutionException, InterruptedException {
        RequestInfo requestInfo = new RequestInfo(this.token);
        requestInfo.execute(id);
        return requestInfo.get();
    }

}
