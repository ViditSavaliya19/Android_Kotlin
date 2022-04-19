package com.example.kotlin10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val rv_view: RecyclerView get() = findViewById(R.id.rv_view)

    var modelList = arrayListOf<ModelData>()
    var name= arrayOf("India","Ukrain","China","Russia","America","Canada","United Kindom")
    var capital = arrayOf("Delhi","Kiv","Beijin","Mosco","Wosington Dc","Torento","London")
    var i:Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        while(i<name.size)
        {
            var modelData =  ModelData(name[i],capital[i])
            modelList.add(modelData)
            i++
        }

        var adapter = MyAdapter(this, modelList)
        var layout = LinearLayoutManager(this)

        rv_view.layoutManager = layout
        rv_view.adapter = adapter

    }
}