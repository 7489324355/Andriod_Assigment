package com.exmple.module4.que_15

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exmple.module4.R
import com.exmple.module4.databinding.ActivityRadioBinding

class RadioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRadioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRadioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.colorRadioGroup.setOnCheckedChangeListener { radioGroup, i ->
            val selectedColor = when (i) {
                R.id.yellowRadioButton->Color.YELLOW
                R.id.redRadioButton -> Color.RED
                R.id.greenRadioButton -> Color.GREEN
                R.id.blueRadioButton -> Color.BLUE
                else -> Color.WHITE
            }
            binding.colorView.setBackgroundColor(selectedColor)

        }
    }
}