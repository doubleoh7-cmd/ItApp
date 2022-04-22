package com.example.itapp.ui.Admissions

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.itapp.databinding.FragmentAdmissionBinding


class AdmissionFragment : Fragment() {

    private var _binding: FragmentAdmissionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAdmissionBinding.inflate(inflater, container, false)

        binding.applyBtn.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://ucc.edu.jm/apply/undergraduate/preform")
            startActivity(openURL)
        }
        return binding.root
    }
}