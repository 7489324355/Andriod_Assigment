package com.exmple.module3application.que_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.exmple.module3application.R

class SecondActivity : AppCompatActivity() {
    val btnsecond: Button
        get() = findViewById(R.id.btn_second)
    val etaddress: EditText
        get() = findViewById(R.id.et_address)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        btnsecond.setOnClickListener{
            var address= etaddress.text.toString().trim()
            var name = intent.getStringExtra("NAME")
            var email = intent.getStringExtra("EMAIL")
            var age = intent.getIntExtra("AGE",0)


            var intent= Intent(this,ThirdActivity::class.java)
            intent.putExtra("ADDRESS",address)
            intent.putExtra("NAME",name)
            intent.putExtra("EMAIL",email)
            intent.putExtra("AGE",age)
            startActivity(intent)

//            Toast.makeText(this, """
//              name : $name
//              email : $email  age : $age
//              address:$address
//           """.trimIndent(), Toast.LENGTH_SHORT).show()
        }

    }
}