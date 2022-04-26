package com.example.kotlin10.Screen.api_screen.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.kotlin10.R
import com.example.kotlin10.Screen.api_screen.controller.ApiCalient
import com.example.kotlin10.Screen.api_screen.controller.ApiInterFace
import com.example.kotlin10.Screen.api_screen.model.ModelApi
import com.example.kotlin10.Screen.api_screen.model.PostModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Api_Screem : AppCompatActivity() {

    lateinit var btn_api: Button
    var list = arrayListOf<ModelApi>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_screem)

        btn_api = findViewById<Button>(R.id.btn_api)
        btn_api.setOnClickListener {
//            ApiData()
            postApiCall("Priyanka","Android Developer")
        }
    }

    fun ApiData() {
        var apiinter = ApiCalient().getRetrofit().create(ApiInterFace::class.java)
        apiinter.getData().enqueue(object : Callback<List<ModelApi>> {
            override fun onResponse(
                call: Call<List<ModelApi>>,
                response: Response<List<ModelApi>>
            ) {
                list = response.body() as ArrayList<ModelApi>
                Log.e("TAG", "onResponse: ==== ${list[0].title}")
            }

            override fun onFailure(call: Call<List<ModelApi>>, t: Throwable) {
                Toast.makeText(this@Api_Screem, "" + t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun postApiCall(name: String, job: String) {
        var apiinter = ApiCalient().getRetrofit().create(ApiInterFace::class.java)
        apiinter.postData(name, job).enqueue(object : Callback<PostModel> {
            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
                Toast.makeText(this@Api_Screem, "Success", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<PostModel>, t: Throwable) {
                Toast.makeText(this@Api_Screem, "Failed", Toast.LENGTH_SHORT).show()

            }
        })
    }
}