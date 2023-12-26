package com.example.module5application.Que4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.module5application.ApiEmployeeService
import com.example.module5application.Model.RegisterResponse
import com.example.module5application.Network.ApiEmployee
import com.example.module5application.R
import com.example.module5application.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {

            var name = binding.name.text.toString().trim()
            var email = binding.email.text.toString().trim()
            var contact = binding.mobile.text.toString().trim()

            createAccount(name, email, contact)

        }
        binding.textSign.setOnClickListener {
            var intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createAccount(name: String, email: String, contact: String) {
        ApiEmployee.init().create(flag = 1, name=name, email = email, contact = contact)
            .enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>, response: Response<RegisterResponse>
                ) {

                    if (response.isSuccessful) {

                        var res = response.body()

                        if (res != null) {

                            Toast.makeText(applicationContext, "${res.message}", Toast.LENGTH_SHORT).show()

                            if (res.status == "success") {
                                // manage shared preference for session management
                                // navigate to home activity
                                startActivity(Intent(applicationContext, HomeActivity::class.java))
                            }
                        }

                    }

                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Log.d("TAG", "onFailure: ")
                }

            })




    }
}