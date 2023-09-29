package com.exmple.module4.que_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exmple.module4.R
import com.exmple.module4.databinding.ActivityDisplayNumberBinding

class DisplayNumberActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDisplayNumberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDisplayNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val firstNumber = intent.getIntExtra("firstNumber", 0)
        val secondNumber = intent.getIntExtra("secondNumber", 0)
        val numbersInRange = if (firstNumber <= secondNumber) {
            (firstNumber..secondNumber).joinToString(", ")
        } else {
            (secondNumber..firstNumber).joinToString(", ")
        }
        binding.numbersTextView.text = "Numbers between $firstNumber and $secondNumber: $numbersInRange"

    }
}