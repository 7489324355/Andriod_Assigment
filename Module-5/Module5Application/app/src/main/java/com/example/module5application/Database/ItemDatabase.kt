package com.example.module5application.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.module5application.Dao.ItemDao
import com.example.module5application.Model.Item

@Database(entities = [Item::class], version = 1)
abstract class ItemDatabase: RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object{
        private var INSTENCE:ItemDatabase?=null
        fun getInstance(context: Context):ItemDatabase?{
            if (INSTENCE==null){
                synchronized(this){
                    INSTENCE= Room.databaseBuilder(context, ItemDatabase::class.java, "notes.db").allowMainThreadQueries().build()
                }
            }
            return INSTENCE

        }
    }
}