package com.example.module5application.Model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "item_table")
@Parcelize
data class Item(
    @PrimaryKey(autoGenerate = true)
     var id:Int = 0,
     var title:String,
     var message:String?,
    @ColumnInfo(name = "created_at")
    var createdAt: Long = System.currentTimeMillis()
):Parcelable
