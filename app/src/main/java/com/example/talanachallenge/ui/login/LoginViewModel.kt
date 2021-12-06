package com.example.talanachallenge.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talanachallenge.data.models.LoginRequest
import com.example.talanachallenge.network.ApiService
import com.example.talanachallenge.network.RetrofitEngine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    var loginResponse: MutableLiveData<Boolean> = MutableLiveData()

    fun requestLogin(username: String, password: String) {

        RetrofitEngine.getRetrofitEngine().create(ApiService::class.java)
            .doLogin(LoginRequest(username, password))
            .enqueue(object : Callback<LoginRequest> {

                override fun onResponse(
                    call: Call<LoginRequest>,
                    response: Response<LoginRequest>
                ) {
                    if (response.isSuccessful) {

                        loginResponse.postValue(true)


                    } else {

                        loginResponse.postValue(false)
                    }
                }

                override fun onFailure(call: Call<LoginRequest>, t: Throwable) {

                    loginResponse.postValue(false)
                    t.message?.let { Log.e("Error en LoginRequest", it) }
                }
            })
    }
}