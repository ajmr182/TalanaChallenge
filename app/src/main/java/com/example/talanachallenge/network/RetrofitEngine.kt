package com.example.talanachallenge.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitEngine {

    companion object {

        fun getRetrofitEngine(): Retrofit {

            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.43.132:3100")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }
}