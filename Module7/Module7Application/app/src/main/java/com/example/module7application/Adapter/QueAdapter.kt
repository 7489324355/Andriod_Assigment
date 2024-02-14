package com.example.module7application.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module7application.Model.Que
import com.example.module7application.Que2.PlaySongResourceActivity
import com.example.module7application.Que3.PlayMobileMemoryActivity
import com.example.module7application.Que4.PlaySongServerActivity
import com.example.module7application.Que5.VideoPlayActivity
import com.example.module7application.Que6.SpeechActivity
import com.example.module7application.Que7.WifiActivity
import com.example.module7application.databinding.ItemShowBinding

class QueAdapter(var context:Context,var itemlist:MutableList<Que>):RecyclerView.Adapter<QueAdapter.MyViewHolder>() {
    class MyViewHolder( var binding:ItemShowBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       var binding= ItemShowBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return itemlist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var item = itemlist[position]
        holder.binding.text.text=item.name
        holder.binding.prent.setOnClickListener {
            when(item.id){
                1->{
//                    val intent = Intent(context, ::class.java)
//                    context.startActivity(intent)

                }
                2->{

                    val intent = Intent(context, PlaySongResourceActivity::class.java)
                    context.startActivity(intent)

                }
                3->{

                    val intent = Intent(context, PlayMobileMemoryActivity::class.java)
                    context.startActivity(intent)

                }
                4->{

                    val intent = Intent(context, PlaySongServerActivity::class.java)
                    context.startActivity(intent)

                }
                5->{

                    val intent = Intent(context, VideoPlayActivity::class.java)
                    context.startActivity(intent)

                }
                6->{

                    val intent = Intent(context, SpeechActivity::class.java)
                    context.startActivity(intent)

                }
                7->{

                    val intent = Intent(context, WifiActivity::class.java)
                    context.startActivity(intent)

                }
            }
        }
    }
}