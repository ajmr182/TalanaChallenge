package com.example.talanachallenge.ui.login

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talanachallenge.data.models.Login
import com.example.talanachallenge.network.ApiService
import com.example.talanachallenge.network.RetrofitEngine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.coroutineContext

class LoginViewModel : ViewModel() {

    var loginResponse: MutableLiveData<Boolean> = MutableLiveData()
    fun requestLogin(username: String, password: String) {

        RetrofitEngine.getRetrofitEngine().create(ApiService::class.java)
            .doLogin(Login(username, password))
            .enqueue(object : Callback<Login> {
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    if (response.isSuccessful) {
                        loginResponse.postValue(true)


                    } else {
                        loginResponse.postValue(false)
                    }
                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    loginResponse.postValue(false)
                    t.message?.let { Log.e("Error en Login", it) }
                }
            })
    }
}