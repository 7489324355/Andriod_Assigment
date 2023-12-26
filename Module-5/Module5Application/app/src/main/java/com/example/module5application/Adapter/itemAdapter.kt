package com.example.module5application.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module5application.Model.Item
import com.example.module5application.databinding.AddItemBinding


class itemAdapter(var context: Context, var itemList: MutableList<Item>):
    RecyclerView.Adapter<itemAdapter.MyViewHolder>() {

    var itemeditclicklistener:((position:Int,item: Item)->Unit)?=null
    var itemDeleteClickListener: ((position: Int, item:Item) -> Unit)? = null

    class MyViewHolder(var binding: AddItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding= AddItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemList[position]
        holder.binding.title.text = item.title
        holder.binding.mass.text = item.message

        holder.binding.delete.setOnClickListener {
            itemDeleteClickListener?.invoke(position,item)
        }
        holder.binding.edit.setOnClickListener {
            itemeditclicklistener?.invoke(position, item)
        }
    }

    fun setItems(mutableList: MutableList<Item>) {
        this.itemList = mutableList
        notifyDataSetChanged()
    }
    fun deleteItem(position: Int){
        itemList.removeAt(position)
        notifyItemRemoved(position)
    }


}
