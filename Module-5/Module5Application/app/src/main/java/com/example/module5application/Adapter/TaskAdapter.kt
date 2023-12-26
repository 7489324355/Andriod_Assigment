package com.example.module5application.Adapter

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.module5application.Model.Task
import com.example.module5application.R
import com.example.module5application.databinding.ItemTaskBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class TaskAdapter(var context: Context, var taskList: MutableList<Task>) :
    RecyclerView.Adapter<TaskAdapter.MyViewHolder>() {

    var itemeditclicklistener:((position:Int,task:Task)->Unit)?=null
    var itemDeleteClickListener: ((position: Int, task:Task) -> Unit)? = null

    class MyViewHolder(var bind: ItemTaskBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = ItemTaskBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var task = taskList[position]
        holder.bind.textViewTaskName.text = task.name
        holder.bind.textViewTaskDescription.text = task.description
        holder.bind.textViewTaskDate.text = task.date
        holder.bind.textViewTaskTime.text = task.time

        when (task.priority) {
            "HIGH" -> holder.bind.root.setBackgroundColor(Color.RED)
            "AVERAGE" -> holder.bind.root.setBackgroundColor(Color.BLUE)
            "LOW" -> holder.bind.root.setBackgroundColor(Color.GREEN)
            else -> holder.bind.root.setBackgroundColor(Color.TRANSPARENT)
        }


        holder.bind.btnUpdate.setOnClickListener {
            itemeditclicklistener?.invoke(position, task)
        }
        holder.bind.btnDelete.setOnClickListener {
            itemDeleteClickListener?.invoke(position, task)
        }


    }
    fun setItems(mutableList: MutableList<Task>) {
        this.taskList = mutableList
        notifyDataSetChanged()
    }
    fun deleteItem(position: Int){
        taskList.removeAt(position)
        notifyItemRemoved(position)
    }
}