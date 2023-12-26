package com.example.module5application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module5application.Adapter.QueAdapter
import com.example.module5application.Model.Que
import com.example.module5application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var ItemList= mutableListOf<Que>()
    private lateinit var itemAdapter: QueAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()
        itemAdapter = QueAdapter(this, ItemList)

        binding.recyleview.layoutManager= LinearLayoutManager(this)
        binding.recyleview.adapter = itemAdapter
    }

    private fun prepareData() {

        ItemList.add(
            Que(
                id = 1,
                name = "1.Create an application of todo app using SQLite with function lite to create list of upcoming task, completed task, remove task, update task in daily activity. "

                )
        )
        ItemList.add(
            Que(
                id = 2,
                name = "2.Create a Sticky Notes app with proper customization which can \n" +
                        "insert,view,update,delete using SQLite database",

                )
        )
        ItemList.add(
            Que(
                id = 3,
                name = "3.To create task management application for adding, updating, deleting the task \n" +
                        "and show the tasks in the listview or gridview. Task have name, description, \n" +
                        "date, time, priority. Sort the task by the date and time wise. If task is due then \n" +
                        "automatically show as blue color. It will search the tasks by date wise. If high \n" +
                        "priority then show as red color, average priority as blue color, low priority as \n" +
                        "green color. Select specified item an open context menu to select “Complete \n" +
                        "the Task” then this task ",

                )
        )
        ItemList.add(
            Que(
                id = 4,
                name = "4.Create an application in which employee can login and register with MySQL \n database",

                )
        )
        ItemList.add(
           Que(
                id = 5,
                name = "5.In previous application after logging employee can insert, update and delete \n project details Create an application to select employee profile page in which \n employee can upload profile ",

                )
        )
        ItemList.add(
            Que(
                id = 6,
                name = "6.pic selected from gallery or camera after login to application",

                )
        )

    }
}