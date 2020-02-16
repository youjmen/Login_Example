package com.example.loginproject;

import com.example.loginproject.Resource.Res;
import com.example.loginproject.Resource.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @POST("api/auth/login")
    Call<JsonParse> signinPost(@Body User user);

    @POST("api/users/")
    Call<JsonParse> signupPost(@Body Res res);

    @GET("/api/users/{username}")
    Call<JsonParse> getUserInfo(@Header("Authorization") String token);
}
