package com.example.loginproject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitApi {
    private static RetrofitApi apiInstance = new RetrofitApi();
    public static RetrofitApi getInstance() {
        return apiInstance;
    }
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http:///")
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();
    public ApiInterface apiInterface = retrofit.create(ApiInterface.class);


}
