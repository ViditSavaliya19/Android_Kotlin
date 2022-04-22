package com.example.kotlin10.Screen.shared_screen.view

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin10.R
import com.example.kotlin10.Screen.shared_screen.controller.DataBase

class ExActivity : AppCompatActivity() {
    val read_data: Button get() = findViewById(R.id.read_data)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex)
        var db = DataBase(this)
        read_data.setOnClickListener {
            db.readdata()
        }
    }
}