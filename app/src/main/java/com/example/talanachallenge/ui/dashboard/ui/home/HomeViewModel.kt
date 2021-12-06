package com.example.talanachallenge.ui.dashboard.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talanachallenge.data.models.responses.FeedResponse
import com.example.talanachallenge.network.ApiService
import com.example.talanachallenge.network.RetrofitEngine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    var feedResponse: MutableLiveData<Response<List<FeedResponse>>> = MutableLiveData()

    fun requestFeed() {

        RetrofitEngine.getRetrofitEngine().create(ApiService::class.java)
            .getFeed()
            .enqueue(object : Callback<List<FeedResponse>> {

                override fun onResponse(
                    call: Call<List<FeedResponse>>,
                    response: Response<List<FeedResponse>>
                ) {
                    if (response.isSuccessful) {

                        feedResponse.postValue(response)
                    }
                }

                override fun onFailure(call: Call<List<FeedResponse>>, t: Throwable) {

                    t.message?.let { Log.e("Error en Servidor", it) }
                }
            })
    }
}