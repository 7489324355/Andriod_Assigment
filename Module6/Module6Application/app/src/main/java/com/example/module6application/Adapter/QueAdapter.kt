package com.example.module6application.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module6application.CorrentMapsActivity
import com.example.module6application.Model.Que
import com.example.module6application.Que1.ImagePickActivity
import com.example.module6application.Que3.MapActivity
import com.example.module6application.Que4.PlaceActivity
import com.example.module6application.Que5.GoogleMapsActivity
import com.example.module6application.Que6.BlinkImageActivity
import com.example.module6application.Que7.TrasalateActivity
import com.example.module6application.Que8.ProgressFrameActivity
import com.example.module6application.Que9.SplashActivity
import com.example.module6application.databinding.ItemLayoutBinding

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
                    val intent = Intent(context, ImagePickActivity::class.java)
                    context.startActivity(intent)

                }
                2->{
                    val intent = Intent(context, CorrentMapsActivity::class.java)
                    context.startActivity(intent)

                }
                3->{
                    val intent = Intent(context, MapActivity::class.java)
                    context.startActivity(intent)
                }
                4->{
                    val intent = Intent(context, PlaceActivity::class.java)
                    context.startActivity(intent)
                }
//
                5->{
                    val intent = Intent(context, GoogleMapsActivity::class.java)
                    context.startActivity(intent)
                }
                6->{
                    val intent = Intent(context, BlinkImageActivity::class.java)
                    context.startActivity(intent)
                }
                7->{
                    val intent = Intent(context, TrasalateActivity::class.java)
                    context.startActivity(intent)
                }
                8->{
                    val intent = Intent(context, ProgressFrameActivity::class.java)
                    context.startActivity(intent)
                }
                9->{
                    val intent = Intent(context, SplashActivity::class.java)
                    context.startActivity(intent)
                }

            }

        }

    }

    override fun getItemCount(): Int {
        return ItemList.size
    }
}