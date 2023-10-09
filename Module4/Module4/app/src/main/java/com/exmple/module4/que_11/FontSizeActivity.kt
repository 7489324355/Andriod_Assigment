package com.exmple.module4.que_11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exmple.module4.R
import com.exmple.module4.databinding.ActivityFontSizeBinding

class FontSizeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFontSizeBinding
    private var currentFontSize: Float = 24f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFontSizeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPlus.setOnClickListener {
            increaseFontSize()
        }

        binding.btnMinus.setOnClickListener {
            decreaseFontSize()
        }
    }

    private fun increaseFontSize() {
        currentFontSize += 2 // Increase font size by 2sp
        binding.textView.textSize = currentFontSize
    }

    private fun decreaseFontSize() {
        currentFontSize -= 2 // Decrease font size by 2sp
        binding.textView.textSize = currentFontSize
    }
}