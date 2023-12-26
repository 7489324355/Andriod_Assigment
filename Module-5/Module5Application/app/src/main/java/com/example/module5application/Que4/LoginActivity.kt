package com.example.module5application.Que4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.module5application.Model.RegisterResponse
import com.example.module5application.Network.ApiEmployee
import com.example.module5application.R
import com.example.module5application.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signin.setOnClickListener {
            var email = binding.email.text.toString().trim()
            var password = binding.password.text.toString().trim()
            createAccount(email,password)
        }
        binding.textSignup.setOnClickListener {
            var intent= Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createAccount(email: String, password:String) {

        ApiEmployee.init().loginUser(flag = 6, email = email, password = password)
            .enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>, response: Response<RegisterResponse>
                ) {

                    if (response.isSuccessful) {
                        if (password == "123456") {
                            startActivity(Intent(applicationContext, HomeActivity::class.java))
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "Incorrect password",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }



                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Log.d("TAG", "onFailure: ")
                }

            })

    }
}