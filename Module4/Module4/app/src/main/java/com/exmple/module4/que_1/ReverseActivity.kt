package com.exmple.module4.que_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import com.exmple.module4.R

class ReverseActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var reverseTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reverse)

        editText = findViewById(R.id.editText)
        reverseTextView = findViewById(R.id.reverseTextView)

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


            }

            override fun afterTextChanged(p0: Editable?) {
                val inputText = p0.toString()
                if (inputText.isNotEmpty()) {
                    val reverseText = inputText.reversed()
                    reverseTextView.text = reverseText
                } else {
                    reverseTextView.text = "" // Clear the TextView when input is empty
                }
            }

        })
    }
}