package com.example.module5application.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.module5application.Dao.TaskDao
import com.example.module5application.Dao.TodoDao
import com.example.module5application.Model.Task
import com.example.module5application.Model.TodoTask


@Database(entities = [TodoTask::class], version = 1)
abstract class TodoDatabase : RoomDatabase(){
    // abstract method
    abstract fun taskDao(): TodoDao

    companion object{
        private var INSTENCE:TodoDatabase?=null
        fun getInstance(context: Context):TodoDatabase?{
            if (INSTENCE==null){
                synchronized(this){
                    INSTENCE= Room.databaseBuilder(context, TodoDatabase::class.java, "todotask_database").allowMainThreadQueries().build()
                }
            }
            return INSTENCE

        }
    }
}