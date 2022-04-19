package com.example.kotlin10.Screen.database_screen.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.kotlin10.R
import com.example.kotlin10.Screen.database_screen.controller.DBHelper

class Database_Screen : AppCompatActivity() {

    val insert_btn : Button get() = findViewById(R.id.insert_btn)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database_screen)

        var dbHelper = DBHelper(this)
        insert_btn.setOnClickListener {
            dbHelper.insertData("Sahil","4918","9955336622")
        }
    }
}