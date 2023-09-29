package com.exmple.module3application.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exmple.module3application.Module.Item
import com.exmple.module3application.databinding.ItemLayoutBinding
import com.exmple.module3application.que_1.HelloWorldActivity
import com.exmple.module3application.que_2.ColorActivity
import com.exmple.module3application.que_3.FirstActivity
import com.exmple.module3application.que_5.LoginActivity
import com.exmple.module3application.que_5.RegisterActivity
import com.exmple.module3application.que_6.JavaFileActivity
import com.exmple.module3application.que_7.LifecycleActivity
import com.exmple.module3application.que_8.FragmentActivity
import com.exmple.module3application.que_9.pageActivity

class ItemAdapter(var context: Context, var ItemList: MutableList<Item>):
    RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

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
                    val intent = Intent(context, HelloWorldActivity::class.java)
                    context.startActivity(intent)

                }
                2->{
                    val intent = Intent(context, ColorActivity::class.java)
                    context.startActivity(intent)

                }
                3->{
                    val intent = Intent(context, FirstActivity::class.java)
                    context.startActivity(intent)
                }
                4->{
                    val intent = Intent(context, FirstActivity::class.java)
                    context.startActivity(intent)
                }

                5->{
                    val intent = Intent(context, RegisterActivity::class.java)
                    context.startActivity(intent)
                }
                6->{
                    val intent = Intent(context, JavaFileActivity::class.java)
                    context.startActivity(intent)
                }
                7->{
                    val intent = Intent(context, LifecycleActivity::class.java)
                    context.startActivity(intent)
                }
                8->{
                    val intent = Intent(context, FragmentActivity::class.java)
                    context.startActivity(intent)
                }
                9->{
                    val intent = Intent(context, pageActivity::class.java)
                    context.startActivity(intent)
                }
            }

        }


    }

    override fun getItemCount(): Int {
        return ItemList.size
    }
}