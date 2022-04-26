package com.example.kotlin10.Screen.api_screen.controller

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCalient {
//    var BASE_URL = "https://jsonplaceholder.typicode.com/"
    var BASE_URL = "https://reqres.in/api/"


    @JvmName("getRetrofit1")
    fun getRetrofit(): Retrofit {

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }

}