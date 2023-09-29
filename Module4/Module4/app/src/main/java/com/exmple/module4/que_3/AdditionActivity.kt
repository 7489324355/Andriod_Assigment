package com.exmple.module4.que_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exmple.module4.R
import com.exmple.module4.databinding.ActivityAdditionBinding

class AdditionActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAdditionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdditionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            calculateResult()

        }
    }

        private fun calculateResult() {
            val selectedOperationId = binding.operationRadioGroup.checkedRadioButtonId
            val number1 = binding.number1EditText.text.toString().toDouble()
            val number2 = binding.number2EditText.text.toString().toDouble()

            val result = when (selectedOperationId) {
                R.id.addRadioButton -> number1 + number2
                R.id.subtractRadioButton -> number1 - number2
                R.id.multiplyRadioButton -> number1 * number2
                R.id.divideRadioButton -> {
                    if (number2 != 0.0) {
                        number1 / number2
                    } else {
                        "Undefined"
                    }
                }
                else -> throw IllegalArgumentException("Invalid operation selected")
            }

            binding.resultTextView.text = "Result: $result"
    }
}