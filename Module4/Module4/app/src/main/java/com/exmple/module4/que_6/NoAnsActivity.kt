package com.exmple.module4.que_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exmple.module4.databinding.ActivityNoAnsBinding

class NoAnsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNoAnsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNoAnsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvName.text="This Question is not for this module"
    }
}