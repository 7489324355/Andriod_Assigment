package com.exmple.module3application.que_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.exmple.module3application.R

class RegisterActivity : AppCompatActivity() {
    val btnsignup : Button
        get() = findViewById(R.id.btn_signup)

    val tvsign : TextView
        get() = findViewById(R.id.text_sign)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnsignup.setOnClickListener {
            var intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        tvsign.setOnClickListener {
            var intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}