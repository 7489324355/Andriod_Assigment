package com.exmple.module4.que_17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exmple.module4.databinding.ActivityToolBarBinding

class ToolBarActivity : AppCompatActivity() {
    private lateinit var binding:ActivityToolBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityToolBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}