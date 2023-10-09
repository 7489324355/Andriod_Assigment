package com.exmple.module4.que_18

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.exmple.module4.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySpinnerBinding
    private var courseset = setOf<String>("Application developer","web Design","Graphics Designing","Fulluter developer")
    private lateinit var coursedapter :ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)



       coursedapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,courseset.toList())
       binding.spinner.adapter = coursedapter


        binding.spinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var course = courseset.toList()[p2]
                Toast.makeText(applicationContext, "$course", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }
}

