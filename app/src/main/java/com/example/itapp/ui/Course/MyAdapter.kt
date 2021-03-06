package com.example.itapp.ui.Course

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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
        holder.courseCode.text = "Code: "+currentItem.Code
        holder.courseCredits.text = "Credits: "+currentItem.Credits.toString()
        holder.coursePre.text = "Pre_Requisites: "+currentItem.PreRequisites
        holder.courseDescription.text = "Description: "+currentItem.Description
    }

    override fun getItemCount(): Int {

        return courseList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val courseName: TextView = itemView.findViewById(R.id.courseTitle)
        val courseCode: TextView = itemView.findViewById(R.id.courseCode)
        val courseCredits: TextView = itemView.findViewById(R.id.detail_credits)
        val coursePre: TextView = itemView.findViewById(R.id.detail_Pre_Requisites)
        val courseDescription: TextView = itemView.findViewById(R.id.detail_Description)
    }
}