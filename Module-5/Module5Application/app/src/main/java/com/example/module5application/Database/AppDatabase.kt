package com.example.module5application.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.module5application.Dao.TaskDao
import com.example.module5application.Model.Task


@Database(entities = [Task::class], version = 1)
abstract class AppDatabase :RoomDatabase(){
    // abstract method
    abstract fun taskDao(): TaskDao

    companion object{
        private var INSTENCE:AppDatabase?=null
        fun getInstance(context: Context):AppDatabase?{
            if (INSTENCE==null){
                synchronized(this){
                    INSTENCE= Room.databaseBuilder(context, AppDatabase::class.java, "task_database").allowMainThreadQueries().build()
                }
            }
            return INSTENCE

        }
    }
}