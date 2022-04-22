package com.example.kotlin10.Screen.database_screen.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.kotlin10.R
import com.example.kotlin10.Screen.database_screen.controller.DBHelper
import com.example.kotlin10.Screen.database_screen.model.datamodel

class Database_Screen : AppCompatActivity() {

    val insert_btn : Button get() = findViewById(R.id.insert_btn)
    val read_btn : Button get() = findViewById(R.id.read_btn)
    val update_btn : Button get() = findViewById(R.id.update_btn)
    val delete_btn : Button get() = findViewById(R.id.delete_btn)

    var list = arrayListOf<datamodel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database_screen)

        var dbHelper = DBHelper(this)
        insert_btn.setOnClickListener {
            dbHelper.insertData("Sahil","4918","9955336622")
        }

        read_btn.setOnClickListener {
          list =  dbHelper.readData()
        }

        update_btn.setOnClickListener {
            dbHelper.updateData("5","piyush","88856","8585858585")
        }
        delete_btn.setOnClickListener {
            dbHelper.deleteData("5")
        }
    }
}