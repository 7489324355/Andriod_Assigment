package com.example.module5application.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.module5application.Model.Task
import com.example.module5application.Model.TodoTask


@Dao
interface TodoDao {

    @Query("SELECT * FROM  todotask_table  ORDER BY date DESC")
    fun getCompletedTasks(): List<TodoTask>

    @Query("SELECT * FROM todotask_table ORDER BY date ASC")
    fun getUpcomingTasks(): MutableList<TodoTask>

    @Query("select * from todotask_table ")
    fun getAllTask(): MutableList<TodoTask>


    @Insert
    fun insertTask(task: TodoTask)

    @Update
    fun updateTask(task: TodoTask)

    @Delete
    fun deleteTask(task: TodoTask)
}