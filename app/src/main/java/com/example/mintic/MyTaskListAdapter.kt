package com.example.mintic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MyTaskListAdapter (context : AppCompatActivity, val info :Bundle)
    :RecyclerView.Adapter<MyTaskListAdapter.MyViewHolder>()
{
        class MyViewHolder(val layout : View) :RecyclerView.ViewHolder(layout)
    private var context : AppCompatActivity = context
    var myTaskTitle : ArrayList<String> = info.getStringArrayList("title") as ArrayList<String>
    var myTaskTimes : ArrayList<String> = info.getStringArrayList("times") as ArrayList<String>
    var myTaskPlaces : ArrayList<String> = info.getStringArrayList("places") as ArrayList<String>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.task_list_items,parent,false)
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var textViewTask =holder

    }

}