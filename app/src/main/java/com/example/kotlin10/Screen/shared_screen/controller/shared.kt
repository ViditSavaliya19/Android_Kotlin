package com.example.kotlin10.Screen.shared_screen.controller

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class shared(val context:Context) {


    fun setSharedPref(email:String,password:String)
    {
        var sharedpref =context.getSharedPreferences("MyPref",MODE_PRIVATE)
        var editor =  sharedpref.edit()
        editor.putString("e1",email)
        editor.putString("p1",password)
        editor.commit()
    }

    fun getSharedPref()
    {
        var sharedpref =context.getSharedPreferences("MyPref",MODE_PRIVATE)
        var email = sharedpref.getString("e1",null)
        var password = sharedpref.getString("p1",null)
    }

}