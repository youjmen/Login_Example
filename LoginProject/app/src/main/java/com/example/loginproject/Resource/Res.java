package com.example.loginproject.Resource;

import com.google.gson.annotations.SerializedName;

public class Res {

    @SerializedName("username")
    String resName;
    @SerializedName("password")
    String resPw;
    @SerializedName("email")
    String resEmail;

    public Res(String resEmail, String resPw, String resName)
    {
        this.resEmail = resEmail;
        this.resPw = resPw;
        this.resName = resName;
    }
}
