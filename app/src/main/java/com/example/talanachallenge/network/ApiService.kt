package com.example.talanachallenge.network

import com.example.talanachallenge.data.models.responses.FeedResponse
import com.example.talanachallenge.data.models.LoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("/api/login")
    fun doLogin(
        @Body user: LoginRequest
    ): Call<LoginRequest>

    @GET("/api/feed")
    fun getFeed(): Call<List<FeedResponse>>
}