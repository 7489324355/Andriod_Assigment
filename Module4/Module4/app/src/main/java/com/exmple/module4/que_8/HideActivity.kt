package com.exmple.module4.que_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.exmple.module4.R
import com.exmple.module4.databinding.ActivityHideBinding

class HideActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHideBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hideButton.setOnClickListener {
            // Hide the TextView
            binding.myTextView.visibility = View.INVISIBLE
        }

        binding.showButton.setOnClickListener {
            // Show the TextView
            binding.myTextView.visibility = View.VISIBLE
        }
    }
}