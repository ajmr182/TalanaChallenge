package com.example.talanachallenge.network

import com.example.talanachallenge.data.models.responses.FeedResponse
import com.example.talanachallenge.data.models.Login
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("/api/login")
    fun doLogin(
       @Body user:Login
    ): Call<Login>

    @GET("/api/feed")
    fun getFeed(): Call<List<FeedResponse>>
}