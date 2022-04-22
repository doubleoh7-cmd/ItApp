package com.example.itapp.ui.Socialmedia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.itapp.R
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

        val fb = "https:www.facebook.com/uccjamaica/"
        val insta = "https:www.instagram.com/uccjamaica/"
        val twitter = "https:www.twitter.com/uccjamaica/"

        binding.uccFacebook.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("link", fb)
            val fragment = SocailViewFragment()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.frameLayout, fragment)
                ?.commit()
        }

        binding.uccInstagram.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("link", insta)
            val fragment = SocailViewFragment()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.frameLayout, fragment)
                ?.commit()
        }

        binding.uccTwitter.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("link", twitter)
            val fragment = SocailViewFragment()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.frameLayout, fragment)
                ?.commit()
        }

        return binding.root
    }
}