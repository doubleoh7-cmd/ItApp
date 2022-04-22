package com.example.itapp.ui.Timetable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.itapp.R
import com.example.itapp.databinding.FragmentCourseBinding
import com.example.itapp.databinding.FragmentTimeTableBinding
import com.example.itapp.ui.Course.MyAdapter
import com.example.itapp.ui.Course.course
import com.google.firebase.database.*


class TimeTableFragment : Fragment() {

    private var _binding: FragmentTimeTableBinding? = null
    private val binding get() = _binding!!

    private lateinit var dbref: DatabaseReference
    private lateinit var timeArrayList: ArrayList<timetable>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTimeTableBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        timeArrayList = arrayListOf<timetable>()
        binding.recyclerView.setHasFixedSize(true)

        getTimeTable()

        return binding.root
    }

    private fun getTimeTable() {
        dbref = FirebaseDatabase.getInstance().getReference("Course")
        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (timetableSnapshot in snapshot.children) {
                        val timetable = timetableSnapshot.getValue(timetable::class.java)
                        timeArrayList.add(timetable!!)
                    }
                    binding.recyclerView.adapter = MyAdapterTime(timeArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}