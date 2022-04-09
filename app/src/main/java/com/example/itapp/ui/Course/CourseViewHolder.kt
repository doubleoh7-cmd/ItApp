package com.example.itapp.ui.Course

import androidx.recyclerview.widget.RecyclerView
import com.example.itapp.databinding.CourseCellBinding
import com.example.itapp.databinding.FragmentLoginBinding

class CourseViewHolder(
    private val courseCellBinding: CourseCellBinding,
    private val clickListener: CourseClickListener
) : RecyclerView.ViewHolder(courseCellBinding.root)
{
    fun bindCourse(course: Course) {
        courseCellBinding.cover.setImageResource(course.cover)
        courseCellBinding.courseTitle.text = course.name
        courseCellBinding.courseCode.text = course.description
        courseCellBinding.cardView.setOnClickListener {
            clickListener.onClick(course)
        }
    }
}