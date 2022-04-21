package com.example.itapp.ui.Socialmedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.itapp.R
import com.example.itapp.databinding.FragmentSocailViewBinding
import com.example.itapp.databinding.FragmentSocialMediaBinding


class SocailViewFragment : Fragment() {

    private var _binding: FragmentSocailViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSocailViewBinding.inflate(inflater, container, false)
        val fb = "https:www.facebook.com/uccjamaica/"
        val insta = "https:www.instagram.com/uccjamaica/"
        val twitter = "https:www.twitter.com/ucctwitter/"

        binding.wvSocial.settings.javaScriptEnabled = true
        binding.wvSocial.webViewClient
        binding.wvSocial.loadUrl(fb)
        return binding.root
    }
}