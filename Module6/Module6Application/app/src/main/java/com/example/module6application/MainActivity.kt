package com.example.module6application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module6application.Adapter.QueAdapter
import com.example.module6application.Model.Que
import com.example.module6application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var ItemList= mutableListOf<Que>()
    private lateinit var itemAdapter: QueAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareData()
        itemAdapter = QueAdapter(this, ItemList)

        binding.recyleview.layoutManager= LinearLayoutManager(this)
        binding.recyleview.adapter = itemAdapter


    }

    private fun prepareData() {

        ItemList.add(
            Que(
                id = 1,
                name = "1.pic selected from gallery or camera after login to application"
            )
        )
        ItemList.add(
            Que(
                id = 2,
                name = "2.Create an application to display Google map with current location also give\n options to change mode in map",

                )
        )
        ItemList.add(
            Que(
                id = 3,
                name = "3.Create an application to input address and display marker on that address",

                )
        )
        ItemList.add(
            Que(
                id = 4,
                name = "4.Create an application to suggest places as user type with help of Place\n autocomplete",

                )
        )
        ItemList.add(
            Que(
                id = 5,
                name = "5.service provide by Google"
                )
        )
        ItemList.add(
            Que(
                id = 6,
                name = "6.Write a code to rotate image Write a code to blink image",

                )
        )
        ItemList.add(
            Que(
                id = 7,
                name = "7.Write a code to move image from one place to another place Write a code to zoom in / out image using animation",

                )
        )
        ItemList.add(
            Que(
                id = 8,
                name = "8.Write a code to show progress frame by frame animation",

                )
        )
        ItemList.add(
            Que(
                id = 9,
                name = "9.set animation on splash screen with app logo",

                )
        )

    }
}