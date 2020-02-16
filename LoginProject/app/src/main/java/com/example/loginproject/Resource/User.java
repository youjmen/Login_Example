package com.example.loginproject.Resource;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("email")
    String userEmail;
    @SerializedName("password")
    String userPw;

    public User(String userEmail, String userPw){
        this.userEmail = userEmail;
        this.userPw = userPw;
    }


}
