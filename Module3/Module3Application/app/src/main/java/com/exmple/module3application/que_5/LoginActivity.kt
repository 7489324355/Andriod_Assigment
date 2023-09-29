package com.exmple.module3application.que_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.exmple.module3application.R

class LoginActivity : AppCompatActivity() {
    val tvsignin: TextView
        get() = findViewById(R.id.text_signin)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvsignin.setOnClickListener {
            var intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}