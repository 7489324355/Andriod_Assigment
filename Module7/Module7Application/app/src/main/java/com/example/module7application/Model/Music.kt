package com.example.module7application.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Music(
    var id: String? = null,
    var name: String? = null,
    var singername:String?=null,
    var image: String? = null,
    var music:String?=null,
    var createdAt: Long = System.currentTimeMillis()
):Parcelable {
    override fun toString(): String {
        return name!!
        return singername!!
        return music!!
    }
}
