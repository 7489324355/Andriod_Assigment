package com.example.module5application.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module5application.Model.TodoTask
import com.example.module5application.databinding.TodoTaskBinding

class TodoAdapter(var context: Context, var taskList: MutableList<TodoTask>) :
    RecyclerView.Adapter<TodoAdapter.MyViewHolder>() {

    var itemeditclicklistener:((position:Int,task: TodoTask)->Unit)?=null
    var itemDeleteClickListener: ((position: Int, task: TodoTask) -> Unit)? = null

    class MyViewHolder(var bind: TodoTaskBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = TodoTaskBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var task = taskList[position]
        holder.bind.title.text= task.title
        holder.bind.desc.text = task.description




        holder.bind.edit.setOnClickListener {
            itemeditclicklistener?.invoke(position, task)
        }
        holder.bind.delete.setOnClickListener {
            itemDeleteClickListener?.invoke(position, task)
        }



    }
    fun setItems(mutableList: MutableList<TodoTask>) {
        this.taskList = mutableList
        notifyDataSetChanged()
    }
    fun deleteItem(position: Int){
        taskList.removeAt(position)
        notifyItemRemoved(position)
    }


}