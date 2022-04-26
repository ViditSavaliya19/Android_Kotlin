package com.example.kotlin10.Screen.api_screen.controller

import com.example.kotlin10.Screen.api_screen.model.ModelApi
import com.example.kotlin10.Screen.api_screen.model.PostModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterFace {


    @GET("posts")
    fun getData() : Call<List<ModelApi>>

    @FormUrlEncoded
    @POST("users")
    fun postData(@Field("name")name:String,@Field("job") job:String) : Call<PostModel>
}