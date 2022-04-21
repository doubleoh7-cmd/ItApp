package com.example.itapp.ui.Socialmedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.itapp.R
import com.example.itapp.databinding.FragmentFacultyBinding
import com.example.itapp.databinding.FragmentSocialMediaBinding


class SocialMediaFragment : Fragment() {

    private var _binding: FragmentSocialMediaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSocialMediaBinding.inflate(inflater, container, false)

        binding.uccFacebook.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.frameLayout, SocailViewFragment())
                ?.commit()
        }

        return binding.root
    }
}