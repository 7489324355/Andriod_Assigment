package com.example.module5application.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.module5application.Model.Task
import java.util.Date

@Dao
interface TaskDao {
    @Insert
    fun insertTask(task:Task)

    @Query("select * from task_table ORDER BY date ASC, time ASC")
    fun getAllTask(): MutableList<Task>

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)


}