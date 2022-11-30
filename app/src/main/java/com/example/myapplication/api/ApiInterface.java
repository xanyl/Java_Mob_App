package com.example.myapplication.api;

import com.example.myapplication.response.FoodResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("api/food")
    Call <FoodResponse> getFood();
}
