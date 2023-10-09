package com.exmple.module4.Adpater

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.window.SplashScreen
import androidx.recyclerview.widget.RecyclerView
import com.exmple.module4.Module.Item
import com.exmple.module4.databinding.ItemLayoutBinding
import com.exmple.module4.que_1.ReverseActivity
import com.exmple.module4.que_10.PdfActivity
import com.exmple.module4.que_11.FontSizeActivity
import com.exmple.module4.que_12.EditActivity
import com.exmple.module4.que_13.CheckBoxActivity
import com.exmple.module4.que_14.ArrayActivity
import com.exmple.module4.que_15.RadioActivity
import com.exmple.module4.que_17.ToolBarActivity
import com.exmple.module4.que_18.SpinnerActivity
import com.exmple.module4.que_2.NumberActivity
import com.exmple.module4.que_3.AdditionActivity
import com.exmple.module4.que_4.SplashActivity
import com.exmple.module4.que_5.WebActivity
import com.exmple.module4.que_6.NoAnsActivity
import com.exmple.module4.que_8.HideActivity
import com.exmple.module4.que_9.TableActivity

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
                    val intent = Intent(context, ReverseActivity::class.java)
                    context.startActivity(intent)

                }
                2->{
                    val intent = Intent(context, NumberActivity::class.java)
                    context.startActivity(intent)

                }
                3->{
                    val intent = Intent(context, AdditionActivity::class.java)
                    context.startActivity(intent)
                }
                4->{
                    val intent = Intent(context, SplashActivity::class.java)
                    context.startActivity(intent)
                }

                5->{
                    val intent = Intent(context, WebActivity::class.java)
                    context.startActivity(intent)
                }
                6->{
                    val intent = Intent(context, NoAnsActivity::class.java)
                    context.startActivity(intent)
                }
                7->{
                    val intent = Intent(context,  NoAnsActivity::class.java)
                    context.startActivity(intent)
                }
                8->{
                    val intent = Intent(context, HideActivity::class.java)
                    context.startActivity(intent)
                }
                9->{
                    val intent = Intent(context, TableActivity::class.java)
                    context.startActivity(intent)
                }
                10->{
                    val intent = Intent(context, PdfActivity::class.java)
                    context.startActivity(intent)
                }
                11->{
                    val intent = Intent(context, FontSizeActivity::class.java)
                    context.startActivity(intent)
                }
                12->{
                    val intent = Intent(context, EditActivity::class.java)
                    context.startActivity(intent)
                }
                13->{
                    val intent = Intent(context, CheckBoxActivity::class.java)
                    context.startActivity(intent)
                }
                14->{
                    val intent = Intent(context, ArrayActivity::class.java)
                    context.startActivity(intent)
                }
                15->{
                    val intent = Intent(context, RadioActivity::class.java)
                    context.startActivity(intent)
                }
                16->{
                    val intent = Intent(context, NoAnsActivity::class.java)
                    context.startActivity(intent)
                }
                17->{
                    val intent = Intent(context, ToolBarActivity::class.java)
                    context.startActivity(intent)
                }
                18->{
                    val intent = Intent(context, SpinnerActivity::class.java)
                    context.startActivity(intent)
                }

            }

        }


    }

    override fun getItemCount(): Int {
        return ItemList.size
    }
}