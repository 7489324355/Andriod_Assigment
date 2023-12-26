package com.example.module5application.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import com.example.module5application.Model.Employee
import com.example.module5application.R
import com.example.module5application.databinding.UserItemBinding

import com.google.android.material.bottomsheet.BottomSheetDialog
import com.squareup.picasso.Picasso
import java.io.IOException


class UserAdapter(var context: Context, var userList: MutableList<Employee>): RecyclerView.Adapter<UserAdapter.MyViewHolder>()
{
    var itemDeleteClickListener: ((position: Int, user:Employee) -> Unit)? = null
    var itemUpdateClickListener: ((position: Int, user:Employee) -> Unit)? = null
    var  itemCardClickListener: ((position: Int, user:Employee) -> Unit)? = null
    var  uploadImageClickListener: ((position: Int, user:Employee) -> Unit)? = null



    class MyViewHolder(var bind: UserItemBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = UserItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return userList.size
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        var user = userList[position]
        holder.bind.number.text = user.contact
        holder.bind.mass.text = user.email
        holder.bind.name.text= user.name

        holder.bind.delete.setOnClickListener {
            itemDeleteClickListener?.invoke(position,user)
        }
        holder.bind.cardclick.setOnClickListener {
            itemCardClickListener?.invoke(position,user)
        }
        holder.bind.edit.setOnClickListener {
            itemUpdateClickListener?.invoke(position,user)

        }
//        holder.bind.profileImageView.setOnClickListener {
//            uploadImageClickListener?.invoke(position, user)
//        }
        if (!user.image.isNullOrEmpty()) {
            Picasso.get().load(user.image).into(holder.bind.profileImageView)
        } else {
            // Handle empty or null image URL, you can set a placeholder image or hide the ImageView
            holder.bind.profileImageView.setOnClickListener {
                uploadImageClickListener?.invoke(position, user)
            }
        }
    }



    fun deleteItem(position: Int){
        userList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateList(userList: MutableList<Employee>) {
        this.userList =userList
        notifyDataSetChanged()

    }


}