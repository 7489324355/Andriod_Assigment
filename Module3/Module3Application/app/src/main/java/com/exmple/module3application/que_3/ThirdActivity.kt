package com.exmple.module3application.que_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.exmple.module3application.R

class ThirdActivity : AppCompatActivity() {
    val tvname: TextView
        get() = findViewById(R.id.tv_name)

    val tvemail: TextView
        get() = findViewById(R.id.tv_email)

    val tvage: TextView
        get() = findViewById(R.id.tv_age)

    val tvaddress: TextView
        get() = findViewById(R.id.tv_address)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        var name = intent.getStringExtra("NAME")
        var email = intent.getStringExtra("EMAIL")
        var age = intent.getIntExtra("AGE",0)
        var address = intent.getStringExtra("ADDRESS")

        if (name != null && email !=null && address !=null){
            tvname.text= "name: $name"
            tvemail.text= "Email : $email"
            tvage.text= "Age: $age"
            tvaddress.text="Address: $address"
        }

    }
}