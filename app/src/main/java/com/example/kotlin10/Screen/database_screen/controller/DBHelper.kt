package com.example.kotlin10.Screen.database_screen.controller

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import com.example.kotlin10.Screen.database_screen.model.datamodel

class DBHelper(val context: Context?) : SQLiteOpenHelper(context, "MyDb.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        var query =
            "CREATE TABLE std (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,grid TEXT,mobile TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun insertData(name: String, grid: String, mobile: String) {
        var db = writableDatabase
        var cv = ContentValues()
        cv.put("name", name)
        cv.put("grid", grid)
        cv.put("mobile", mobile)

        var res = db.insert("std", null, cv)

        Toast.makeText(context, "$res", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("Range")
    fun readData(): ArrayList<datamodel> {
        var list  = arrayListOf<datamodel>()
        var db = readableDatabase
        var query = "SELECT * FROM std"
        var cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                var id = cursor.getString(cursor.getColumnIndex("id"))
                var grid = cursor.getString(cursor.getColumnIndex("grid"))
                var name = cursor.getString(cursor.getColumnIndex("name"))
                var mobile = cursor.getString(cursor.getColumnIndex("mobile"))
                var d1 =datamodel(id,grid,name,mobile)
                list.add(d1)
                Log.e("TAG", "readData: $id == $name == $grid == $mobile" )

            } while (cursor.moveToNext())
        }

        return list;
    }

    fun updateData(id:String,name:String,grid:String,mobile:String)
    {
        var db = writableDatabase
        var cv = ContentValues()
        cv.put("name",name)
        cv.put("grid",grid)
        cv.put("mobile",mobile)

        db.update("std",cv,"id=$id",null)
    }

    fun deleteData(id:String)
    {
        var db =writableDatabase
        db.delete("std","id=$id",null)
    }
}














