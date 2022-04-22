package com.example.itapp.ui.Socialmedia

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
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
        val args = this.arguments
        val inputLink = args?.get("link").toString()

        binding.wvSocial.settings.javaScriptEnabled = true
        binding.wvSocial.webViewClient = CustomWebViewClient(Activity())
        binding.wvSocial.loadUrl(inputLink)
        return binding.root
    }
}
class CustomWebViewClient internal constructor(private val activity: Activity) :
    WebViewClient() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldOverrideUrlLoading(
        view: WebView?,
        request: WebResourceRequest?
    ): Boolean {
        val url: String = request?.url.toString();
        view?.loadUrl(url)
        return true
    }
    override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
        webView.loadUrl(url)
        return true
    }
    override fun onReceivedError(
        view: WebView,
        request: WebResourceRequest,
        error: WebResourceError
    ) {
        Toast.makeText(activity, "Error! $error", Toast.LENGTH_SHORT).show()
    }
}