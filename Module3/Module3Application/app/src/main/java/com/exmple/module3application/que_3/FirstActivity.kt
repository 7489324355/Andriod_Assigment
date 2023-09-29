package com.exmple.module3application.que_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.exmple.module3application.R

class FirstActivity : AppCompatActivity() {
    val btnfirst : Button
        get()= findViewById(R.id.btn_first)

    val etname: EditText
        get() = findViewById(R.id.et_name)

    val etemail: EditText
        get() = findViewById(R.id.et_email)
    val etage: EditText
        get() = findViewById(R.id.et_age)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_page)
        btnfirst.setOnClickListener{
            var name = etname.text.toString().trim()
            var email = etemail.text.toString().trim()
            var age =
                if (etage.text.toString().trim().isEmpty())0
                else
                    etage.text.toString().trim().toInt()

            var intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("NAME",name)
            intent.putExtra("EMAIL",email)
            intent.putExtra("AGE",age)
            startActivity(intent)



//            Toast.makeText(this, """
//                 name : $name
//                 email : $email  age : $age
//             """.trimIndent(), Toast.LENGTH_SHORT).show()
        }
    }
}