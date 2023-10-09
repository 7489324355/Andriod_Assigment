package com.exmple.module4.que_12

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.viewpager.widget.ViewPager
import com.exmple.module4.R
import com.exmple.module4.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding:ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun createEditTextFields(view: android.view.View) {
        binding.editTextContainer.removeAllViews()
        val numberOfEditText =
            binding.etNumberOfEditText.text.toString().toIntOrNull() ?: 0
        for (i in 1..numberOfEditText) {
            val editText = EditText(this)
            editText.layoutParams =  ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            editText.hint = "EditText $i"
           binding.editTextContainer.addView(editText)
        }
    }

}