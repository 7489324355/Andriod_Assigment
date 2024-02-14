package com.example.module7application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module7application.Adapter.QueAdapter
import com.example.module7application.Model.Que
import com.example.module7application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var mAdapter: QueAdapter
    private var itemlist= mutableListOf<Que>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareData()

           mAdapter= QueAdapter(this,itemlist)
           binding.recycle.layoutManager=LinearLayoutManager(this)
            binding.recycle.adapter=mAdapter


    }
    private fun prepareData(){
        itemlist.add(
         Que(1,"1.set animation on splash screen with app logo")
        )
        itemlist.add(
            Que(2,"2.Create an application to play song from raw resource folder")
        )
        itemlist.add(
            Que(3,"3.Create an application to play song from mobile memory")
        )
        itemlist.add(
            Que(4,"4.Create an application to play song from Server")
        )
        itemlist.add(
            Que(5,"5.use WAKE LOCK when playing video play")
        )
        itemlist.add(
            Que(6,"6.Create an application to convert text typed in edit text into speech")
        )
        itemlist.add(
            Que(7,"7.Create an application for Wi-Fi on-off")
        )

    }
}