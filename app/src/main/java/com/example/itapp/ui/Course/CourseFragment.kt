package com.example.itapp.ui.Course

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.itapp.R
import com.example.itapp.databinding.FragmentCourseBinding
import com.google.firebase.database.*


class CourseFragment : Fragment() {
    private var _binding: FragmentCourseBinding? = null
    private val binding get() = _binding!!

    private lateinit var dbref: DatabaseReference
    private lateinit var courseRecyclerView: RecyclerView
    private lateinit var courseArrayList: ArrayList<course>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCourseBinding.inflate(inflater, container, false
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        courseArrayList = arrayListOf<course>()
        binding.recyclerView.setHasFixedSize(true)

        getCourseData()

        return binding.root
    }

    private fun getCourseData(){
        dbref = FirebaseDatabase.getInstance().getReference("Course")
        dbref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                binding.progressBar.visibility = View.GONE

                if(snapshot.exists()){
                    for (courseSnapshot in snapshot.children){
                        val course = courseSnapshot.getValue(course::class.java)
                        courseArrayList.add(course!!)
                    }
                    binding.recyclerView.adapter = MyAdapter(courseArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}