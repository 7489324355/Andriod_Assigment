package com.exmple.module4.que_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exmple.module4.R
import com.exmple.module4.databinding.ActivityNumberBinding

class NumberActivity : AppCompatActivity() {
    private lateinit var binding:ActivityNumberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.click.setOnClickListener {
            val firstNumber = binding.firstNumberEditText.text.toString().toIntOrNull()
            val secondNumber = binding.secondNumberEditText.text.toString().toIntOrNull()

            if (firstNumber != null && secondNumber != null) {
                val intent = Intent(this, DisplayNumberActivity::class.java)
                intent.putExtra("firstNumber", firstNumber)
                intent.putExtra("secondNumber", secondNumber)
                startActivity(intent)
            }
        }


    }
}