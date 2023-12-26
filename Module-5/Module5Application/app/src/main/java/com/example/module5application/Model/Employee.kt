package com.example.module5application.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import okhttp3.MultipartBody
import retrofit2.http.Part

@Parcelize
data class Employee(
    var id:Int,
    var name:String,
    var email:String,
    @SerializedName("mobile")
    var contact:String,
    var image: String=""
): Parcelable
