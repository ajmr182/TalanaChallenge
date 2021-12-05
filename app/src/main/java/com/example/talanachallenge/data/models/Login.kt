package com.example.talanachallenge.data.models

import com.google.gson.annotations.SerializedName

data class Login (
    @SerializedName("username") var username:String,
    @SerializedName("password") var password:String
        )
