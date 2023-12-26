package com.example.module5application.Que3

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.module5application.Database.AppDatabase

import com.example.module5application.Model.Task
import com.example.module5application.databinding.ActivityTaskAddBinding
import kotlin.concurrent.thread

class TaskAddActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTaskAddBinding
    var db: AppDatabase? = null
    private var task: Task? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTaskAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = AppDatabase.getInstance(this)




        task = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("task", Task::class.java)
        } else {
            intent.getParcelableExtra("task")
        }

        task?.let {
            binding.btnAddCuisines.text = "Update Task"
            binding.etName.setText(it.name)
            binding.etDesc.setText(it.description)
            binding.etDate.setText(it.date)
            binding.etTime.setText(it.time)
            binding.etPriority.setText(it.priority)

        }

        binding.btnAddCuisines.setOnClickListener {
            var title = binding.etName.text.toString().trim()
            var desc = binding.etDesc.text.toString().trim()
            var date = binding.etDate.text.toString().trim()
            var time = binding.etTime.text.toString().trim()
            var priority = binding.etPriority.text.toString().trim()


            updaterecord(title, desc, date, time, priority)
        }


}


private fun updaterecord(title: String, desc: String, date:String, time:String, priority: String) {
    var message = ""

    thread(start = true) {

        var taskobject = Task(
            name = title, description = desc, date = date, time = time, priority =priority,
            id = if ( task != null) task!!.id else 0,
            createdAt = if (task != null) task!!.createdAt else System.currentTimeMillis(),
        )

        try {
            if (task != null) {
                //update
                db!!.taskDao().updateTask(taskobject)
                message = "Record updated successfully"
            } else {
                //add
                db!!.taskDao().insertTask(taskobject)
                message = "Record added successfully"
            }

            runOnUiThread {
                Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
                onBackPressedDispatcher.onBackPressed()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    }
}