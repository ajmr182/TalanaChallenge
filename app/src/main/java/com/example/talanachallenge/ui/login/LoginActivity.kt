package com.example.talanachallenge.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.talanachallenge.databinding.ActivityLoginBinding
import com.example.talanachallenge.ui.dashboard.BottomActivity

class LoginActivity : AppCompatActivity() {
    lateinit var loginViewModel: LoginViewModel
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel = ViewModelProvider(this)
            .get(LoginViewModel::class.java)
        initViews()
        startObservables()
    }

    fun initViews() {

        binding.btnEnter.setOnClickListener {
            if (binding.etUserName.text.isNotEmpty() && binding.etPassword.text.isNotEmpty()) {
                loginViewModel.requestLogin(
                    binding.etUserName.text.toString(),
                    binding.etPassword.text.toString()
                )
            } else {
                Toast.makeText(
                    applicationContext,
                    "Debes Llenar Todos los Campos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun startObservables() {
        loginViewModel.loginResponse.observe(this, Observer {
            if (it) {
                val intent = Intent(applicationContext, BottomActivity::class.java)
                startActivity(intent)
            } else {
                Log.e("error", "error credentials")
                Toast.makeText(
                    applicationContext,
                    "Usuario o Contraseña Incorrectas",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}