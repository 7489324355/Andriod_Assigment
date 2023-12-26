package com.example.module5application.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module5application.Model.Que
import com.example.module5application.Que1.TodoActivity
import com.example.module5application.Que2.NoteActivity
import com.example.module5application.Que3.MainActivity
import com.example.module5application.Que4.LoginActivity
import com.example.module5application.Que6.ImagePickActivity
import com.example.module5application.databinding.ItemLayoutBinding


class QueAdapter(var context: Context, var ItemList: MutableList<Que>):
    RecyclerView.Adapter<QueAdapter.MyViewHolder>() {

    class MyViewHolder(var binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = ItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var item = ItemList[position]
        holder.binding.tvName.text="${item.name}"

        holder.binding.prent.setOnClickListener {
            when(item.id){
                1->{
                    val intent = Intent(context, TodoActivity::class.java)
                    context.startActivity(intent)

                }
                2->{
                    val intent = Intent(context, NoteActivity::class.java)
                    context.startActivity(intent)

                }
                3->{
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }
                4->{
                    val intent = Intent(context, LoginActivity::class.java)
                    context.startActivity(intent)
                }

                5->{
                    val intent = Intent(context, LoginActivity::class.java)
                    context.startActivity(intent)
                }
                6->{
                    val intent = Intent(context, ImagePickActivity::class.java)
                    context.startActivity(intent)
                }

            }

        }


    }

    override fun getItemCount(): Int {
        return ItemList.size
    }
}