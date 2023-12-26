package com.example.module5application

import com.example.module5application.Model.RegisterResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiEmployeeService {

    @FormUrlEncoded
    @POST("employee.php")
    fun create(
        @Field("flag") flag: Int,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("mobile") contact: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("employee.php")
    fun getUsers(
        @Field("flag") flag: Int
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("employee.php")
    fun updateUser(
        @Field("flag") flag: Int,
        @Field("id") id: Int,
        @Field("name") name: String,
        @Field("mobile") contact: String,
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("employee.php")
    fun deleteUser(
        @Field("flag") flag: Int,
        @Field("id") id: Int
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("employee.php")
    fun loginUser(
        @Field("flag") flag: Int,
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("employee.php")
    fun uploadProfileImage(
        @Field("flag") flag: Int,
        @Field("id") id: Int,
        @Field("image") image: MultipartBody.Part, // Include the base64 encoded image or use other methods
    ): Call<RegisterResponse>




}