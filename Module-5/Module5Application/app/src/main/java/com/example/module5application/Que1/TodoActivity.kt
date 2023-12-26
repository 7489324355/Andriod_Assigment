package com.example.module5application.Que1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module5application.Adapter.CompleteTaskAdapter
import com.example.module5application.Adapter.TodoAdapter
import com.example.module5application.Database.ItemDatabase
import com.example.module5application.Database.TodoDatabase
import com.example.module5application.Model.Item
import com.example.module5application.Model.TodoTask
import com.example.module5application.databinding.ActivityTodoBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TodoActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTodoBinding
    private lateinit var taskAdapter: TodoAdapter
    private lateinit var comletetaskAdapter: CompleteTaskAdapter
    private var taskList = mutableListOf<TodoTask>()
    var db: TodoDatabase? = null
//    private var task: TodoTask? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TodoDatabase.getInstance(this)

    taskAdapter = TodoAdapter(this, taskList)
    binding.upcomingtask.layoutManager = LinearLayoutManager(this)
    binding.upcomingtask.adapter = taskAdapter

    comletetaskAdapter = CompleteTaskAdapter(this, taskList)
    binding.completetask.layoutManager = LinearLayoutManager(this)
    binding.completetask.adapter = comletetaskAdapter

        taskAdapter.itemeditclicklistener={position, todotask ->
            var intent = Intent(this, AddTodoActivity::class.java)
            intent.putExtra("task", todotask)
            startActivity(intent)
        }
    comletetaskAdapter.itemeditclicklistener={position, todotask ->
        var intent = Intent(this, AddTodoActivity::class.java)
        intent.putExtra("task", todotask)
        startActivity(intent)
    }
    taskAdapter.itemDeleteClickListener = { position, task ->
        showAlertDialog(task, position)

    }
    comletetaskAdapter.itemDeleteClickListener = { position, task ->
        showAlertDialog(task, position)

    }



        binding.btnAddTask.setOnClickListener {
            var intent = Intent(this, AddTodoActivity::class.java)
            startActivity(intent)
        }



    }
    private fun showAlertDialog(task:TodoTask, position:Int) {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Delete")
        builder.setMessage("Are you sure you want to delete this item?")
        builder.setPositiveButton("Delete", DialogInterface.OnClickListener { dialog, which ->
           TodoDatabase.getInstance(this)?.taskDao()!!.deleteTask(task)
            Toast.makeText(this, "Item deleted", Toast.LENGTH_SHORT).show()
            taskAdapter.deleteItem(position)
            comletetaskAdapter.deleteItem(position)
        })
        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->

        })
        var dialog = builder.create()
        dialog.show()

    }
    private fun readCuisineList() {
        val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        taskList = TodoDatabase.getInstance(this)?.taskDao()!!.getAllTask()
            .filter { task -> task.date >= currentDate }
            .toMutableList()
        taskAdapter.setItems(taskList)
    }
    private fun readCompletedTasks() {
        val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        taskList = TodoDatabase.getInstance(this)?.taskDao()!!.getAllTask()
            .filter { task -> task.date <= currentDate }
            .toMutableList()
        comletetaskAdapter.setItems(taskList)
    }
    override fun onResume() {
        super.onResume()
        readCuisineList()
        readCompletedTasks()

    }

}