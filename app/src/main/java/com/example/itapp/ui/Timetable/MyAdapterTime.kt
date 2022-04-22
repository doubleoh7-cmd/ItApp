package com.example.itapp.ui.Timetable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.itapp.R

class MyAdapterTime(private val TimeList: ArrayList<timetable>) : RecyclerView.Adapter<MyAdapterTime.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterTime.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.course_cell,
            parent,false)
        return MyAdapterTime.MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapterTime.MyViewHolder, position: Int) {
        val currentItem = TimeList[position]
        holder.className.text = currentItem.Name
        holder.classStart.text = "Start: "+currentItem.Starts
        holder.classEnd.text = "End: "+currentItem.Ends
        holder.classday.text = "Days: "+currentItem.Classday
        holder.classTime.text = "Time: "+currentItem.ClassTime
    }

    override fun getItemCount(): Int {

        return TimeList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val className: TextView = itemView.findViewById(R.id.courseTitle)
        val classStart: TextView = itemView.findViewById(R.id.courseCode)
        val classEnd: TextView = itemView.findViewById(R.id.detail_credits)
        val classday: TextView = itemView.findViewById(R.id.detail_Pre_Requisites)
        val classTime: TextView = itemView.findViewById(R.id.detail_Description)
    }


}