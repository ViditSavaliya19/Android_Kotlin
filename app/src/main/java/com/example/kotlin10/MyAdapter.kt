package com.example.kotlin10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    val mainActivity: MainActivity,
    val modelList: ArrayList<ModelData>,
) : RecyclerView.Adapter<MyAdapter.ViewData>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view  = LayoutInflater.from(mainActivity).inflate(R.layout.item,parent,false)
        return  ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.txt_name.text = modelList[position].name
        holder.txt_capital.text = modelList[position].capital
    }

    override fun getItemCount(): Int {
        return modelList.size
    }


    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView){
        var txt_name = itemView.findViewById<TextView>(R.id.txt_name)
        var txt_capital = itemView.findViewById<TextView>(R.id.txt_capital)
    }
}