package com.exmple.module3application.que_9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.exmple.module3application.R

class pageActivity : AppCompatActivity() {
//    var click : Button
//    get() = findViewById(R.id.btn_click)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)
        var click = findViewById<Button>(R.id.btn_click)


     click.setOnClickListener {
         var fragment = BlankFragment()

         var manager = supportFragmentManager
         var transaction = manager.beginTransaction()
         transaction.replace(R.id.fra,fragment)
         transaction.commit()
     }



    }
}