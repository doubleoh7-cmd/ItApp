package com.example.itapp.ui.Course

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.itapp.databinding.CourseCellBinding

class CardAdapter (
    private val course: List<Course>,
    private val clickListener: CourseClickListener
) : RecyclerView.Adapter<CourseViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CourseCellBinding.inflate(from, parent, false)
        return CourseViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bindCourse(course[position])
    }

    override fun getItemCount(): Int = course.size
}