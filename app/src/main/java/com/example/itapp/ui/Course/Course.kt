package com.example.itapp.ui.Course

var courseList = mutableListOf<Course>()

val COURSE_ID_EXTRA = "courseExtra"

class Course(
    var cover: Int,
    var code: String,
    var name: String,
    var credits: String,
    var pre_requisites: String,
    var description: String,
    val id: Int? = courseList.size
)
