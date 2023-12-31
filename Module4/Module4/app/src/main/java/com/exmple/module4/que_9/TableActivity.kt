package com.exmple.module4.que_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.core.graphics.blue
import com.exmple.module4.R
import com.exmple.module4.databinding.ActivityTableBinding

class TableActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTableBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val data = arrayOf(
            arrayOf("kashish", "komal", "Vimal"),
            arrayOf("Dimpi", "Poonam", "Sneh"),
//            arrayOf("Row 3", "Row 3", "Row 3")
        )

        for (rowData in data) {
            // Create a new TableRow
            val tableRow = TableRow(this)

            for (text in rowData) {
                // Create a new TextView
                val textView = TextView(this)
                textView.text = text
                textView.textSize= 25.1f
                textView.setTextColor(R.color.teal_700)

                // Set layout parameters to specify the column to place the TextView in
                val params = TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT
                )
                params.weight = 1f // You can adjust the weight to control column width
                textView.layoutParams = params

                // Add the TextView to the TableRow
                tableRow.addView(textView)
            }

            // Add the TableRow to the TableLayout
            binding.tableLayout.addView(tableRow)
        }

    }
}