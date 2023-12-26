package com.example.module5application.Que1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.module5application.Database.AppDatabase
import com.example.module5application.Database.TodoDatabase
import com.example.module5application.Model.Task
import com.example.module5application.Model.TodoTask
import com.example.module5application.R
import com.example.module5application.databinding.ActivityAddTodoBinding
import kotlin.concurrent.thread

class AddTodoActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddTodoBinding
    var db: TodoDatabase? = null
    private var task: TodoTask? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = TodoDatabase.getInstance(this)

        task = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("task", TodoTask::class.java)
        } else {
            intent.getParcelableExtra("task")
        }

        task?.let {
            binding.btnSave.text = "Update Task"
            binding.etaddTaskTitle.setText(it.title)
            binding.etaddTaskDescription.setText(it.description)


        }

        binding.btnSave.setOnClickListener {
            var title = binding.etaddTaskTitle.text.toString().trim()
            var desc = binding.etaddTaskDescription.text.toString().trim()
            var date = binding.etdate.text.toString().trim()



            updaterecord(title, desc,date)
        }


    }


    private fun updaterecord(title: String, desc: String,date:String) {
        var message = ""

        thread(start = true) {

            var taskobject = TodoTask(
                title = title, description = desc, date = date,
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