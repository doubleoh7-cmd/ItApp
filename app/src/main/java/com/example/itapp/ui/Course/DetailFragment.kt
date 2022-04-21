package com.example.itapp.ui.Course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.itapp.databinding.FragmentCourseBinding
import com.example.itapp.databinding.FragmentDetailBinding
import com.google.firebase.database.*

class DetailFragment : Fragment(){
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var dbref: DatabaseReference
    private lateinit var courseRecyclerView: RecyclerView
    private lateinit var courseArrayList: ArrayList<course>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false
        )

        return binding.root
    }


}
