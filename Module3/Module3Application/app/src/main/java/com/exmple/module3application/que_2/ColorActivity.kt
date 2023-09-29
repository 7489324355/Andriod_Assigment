package com.exmple.module3application.que_2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exmple.module3application.R
import com.exmple.module3application.databinding.ActivityColorBinding

class ColorActivity : AppCompatActivity() {
    private lateinit var binding:ActivityColorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityColorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGreen.setOnClickListener {
            binding.color.setBackgroundColor(Color.GREEN)

        }
        binding.btnBlack.setOnClickListener {
            binding.color.setBackgroundColor(Color.BLACK)

        }
        binding.btnRed.setOnClickListener {
            binding.color.setBackgroundColor(Color.RED)

        }



    }


}