package com.example.module5application.Model

import android.net.Uri
import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    var status:String,
    var message:String,
    val imageUrl: Uri?,
    @SerializedName("employee")
    var user:MutableList<Employee>
)



