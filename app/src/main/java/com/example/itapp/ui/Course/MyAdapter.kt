package com.example.itapp.ui.Course

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.itapp.R

class MyAdapter(private val courseList: ArrayList<course>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.course_cell,
        parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = courseList[position]
        holder.courseName.text = currentItem.Name
        holder.courseCode.text = currentItem.Code
    }

    override fun getItemCount(): Int {

        return courseList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val courseName: TextView = itemView.findViewById(R.id.courseTitle)
        val courseCode: TextView = itemView.findViewById(R.id.courseCode)

    }
}