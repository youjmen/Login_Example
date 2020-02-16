package com.example.loginproject;

import com.google.gson.annotations.SerializedName;

public class JsonParse {

    @SerializedName("access_token")
    String accessToken;
    @SerializedName("username")
    String userName;
    @SerializedName("password")
    String userPw;
    @SerializedName("email")
    String userEmail;
    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserId(String userId) {
        this.userEmail = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
