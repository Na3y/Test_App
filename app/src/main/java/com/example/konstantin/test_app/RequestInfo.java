package com.example.konstantin.test_app;


import android.os.AsyncTask;

import com.example.konstantin.test_app.POJO.Product;

import java.io.IOException;

import retrofit2.Response;

class RequestInfo extends AsyncTask<String, Void, Product> {

    private String token;
    private Product product;

    RequestInfo(String token){
        this.token = token;
    }

    @Override
    protected Product doInBackground(String... id) {
        try {
            Response<Product> response = App.getApi().getProduct(token, id[0]).execute();
            product = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return product;
    }


}
