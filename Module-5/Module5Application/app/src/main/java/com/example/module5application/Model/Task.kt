package com.example.module5application.Model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var description: String,
    var date: String,
    var time: String,
    var priority: String,
    @ColumnInfo(name = "created_at")
    var createdAt: Long = System.currentTimeMillis(),


): Parcelable

//enum class Priority {
//    HIGH, AVERAGE, LOW
//}
