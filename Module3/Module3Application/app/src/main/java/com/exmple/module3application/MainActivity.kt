package com.exmple.module3application

import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.exmple.module3application.Adapter.ItemAdapter
import com.exmple.module3application.Module.Item
import com.exmple.module3application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var ItemList= mutableListOf<Item>()
    private lateinit var itemAdapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareData()
        itemAdapter = ItemAdapter(this, ItemList)

        binding.recyleview.layoutManager= LinearLayoutManager(this)
        binding.recyleview.adapter = itemAdapter
    }

    private fun prepareData() {
        ItemList.add(
            Item(
                id = 1,
                name = "1.Create “hello world” application",

                )
        )
        ItemList.add(
            Item(
                id = 2,
                name = "2.Change screen background color on different button click event",

                )
        )
        ItemList.add(
            Item(
                id = 3,
                name = "3.Navigate between one screen to another screen ",

                )
        )
        ItemList.add(
            Item(
                id = 4,
                name = "4.Pass data from one screen to second screen",

                )
        )
        ItemList.add(
            Item(
                id = 5,
                name = "5.Design login and registration screen",

                )
        )
        ItemList.add(
            Item(
                id = 6,
                name = "6.What is R.java file",

                )
        )
        ItemList.add(
            Item(
                id = 7,
                name = "7.What is activity and activity lifecycle ",

                )
        )
        ItemList.add(
            Item(
                id = 8,
                name = "8.What is fragment and fragment lifecycle",

                )
        )
        ItemList.add(
            Item(
                id = 9,
                name = "9.Activity to fragment and fragment to activity",

                )
        )

    }
}