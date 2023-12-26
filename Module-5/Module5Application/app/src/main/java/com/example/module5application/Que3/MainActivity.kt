package com.example.module5application.Que3

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.module5application.Adapter.TaskAdapter
import com.example.module5application.Database.AppDatabase
import com.example.module5application.Model.Task
import com.example.module5application.R
import com.example.module5application.databinding.ActivityMain2Binding
import com.example.module5application.databinding.ActivityTaskAddBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMain2Binding
    private lateinit var taskAdapter: TaskAdapter
    private var taskList = mutableListOf<Task>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        taskAdapter = TaskAdapter(this, taskList)
        binding.listview.layoutManager = LinearLayoutManager(this)
        binding.listview.adapter = taskAdapter

       taskAdapter.itemeditclicklistener={position, task ->
            var intent = Intent(this, TaskAddActivity::class.java)
            intent.putExtra("task", task)
            startActivity(intent)
        }
        taskAdapter.itemDeleteClickListener = { position, task ->
            showAlertDialog(task, position)

        }


        binding.btnAddCuisines.setOnClickListener {
            var intent = Intent(this, TaskAddActivity::class.java)
            startActivity(intent)
        }

    }
    private fun readCuisineList() {
       taskList = AppDatabase.getInstance(this)?.taskDao()!!.getAllTask()
       taskAdapter.setItems(taskList)
    }
    override fun onResume() {
        super.onResume()
        readCuisineList()
    }
    private fun showAlertDialog(task:Task ,position:Int) {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Delete")
        builder.setMessage("Are you sure you want to delete this item?")
        builder.setPositiveButton("Delete", DialogInterface.OnClickListener { dialog, which ->
            AppDatabase.getInstance(this)?.taskDao()!!.deleteTask(task)
            Toast.makeText(this, "Item deleted", Toast.LENGTH_SHORT).show()
            taskAdapter.deleteItem(position)
        })
        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->

        })
        var dialog = builder.create()
        dialog.show()

    }

}