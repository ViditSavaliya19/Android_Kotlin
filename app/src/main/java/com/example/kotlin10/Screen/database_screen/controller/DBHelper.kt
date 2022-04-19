package com.example.kotlin10.Screen.database_screen.controller

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DBHelper(val context: Context?) : SQLiteOpenHelper(context, "MyDb.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
       var query = "CREATE TABLE std (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,grid TEXT,mobile TEXT)";
        db!!.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun insertData(name : String,grid :String,mobile:String)
    {
        var db = writableDatabase
        var cv = ContentValues()
        cv.put("name",name)
        cv.put("grid",grid)
        cv.put("mobile",mobile)


        var res = db.insert("std",null,cv)
        Toast.makeText(context,"$res",Toast.LENGTH_SHORT).show()
    }



}