package com.example.konstantin.test_app;


import com.example.konstantin.test_app.POJO.Posts;
import com.example.konstantin.test_app.POJO.Product;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

interface ProducthuntService {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json",
            "Host: api.producthunt.com"
    })
    @GET("v1/categories/{category}/posts")
    Call<Posts> getPost(@Header("Authorization") String authorization, @Path("category") String category);

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json",
            "Host: api.producthunt.com"
    })
    @GET("/v1/posts/{id}")
    Call<Product> getProduct(@Header("Authorization") String authorization, @Path("id") String id);

}
