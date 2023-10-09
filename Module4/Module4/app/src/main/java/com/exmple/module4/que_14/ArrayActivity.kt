package com.exmple.module4.que_14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.exmple.module4.R
import com.exmple.module4.databinding.ActivityArrayBinding

class ArrayActivity : AppCompatActivity() {
    private lateinit var binding:ActivityArrayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityArrayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val stringArray = resources.getStringArray(R.array.my_string_array)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, stringArray)
        binding.list.adapter = adapter



    }
}