package com.example.module5application.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.module5application.Model.Item


@Dao
interface ItemDao {
    @Insert
    fun insertItem(item: Item)

    @Query("select * from item_table")
    fun getAllItem(): MutableList<Item>
//
    @Update
    fun updateItem(item: Item)

    @Delete
    fun deleteItem(item: Item)
}