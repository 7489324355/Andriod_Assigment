package com.example.module5application.Network

import com.example.module5application.ApiEmployeeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiEmployee {

    companion object {

        private var retrofit: Retrofit? = null

        fun init(): ApiEmployeeService {

            if (retrofit == null) {

                retrofit = Retrofit.Builder()
                    .baseUrl("http://192.168.23.1/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(ApiEmployeeService::class.java)
        }

    }
}