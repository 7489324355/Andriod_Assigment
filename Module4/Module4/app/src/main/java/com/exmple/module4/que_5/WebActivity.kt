package com.exmple.module4.que_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.exmple.module4.R
import com.exmple.module4.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initWebView()
    }


    private fun initWebView() {
        val webSettings = binding.webView.settings
        webSettings.javaScriptEnabled = true

        binding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }

        // Load the Google URL
        binding.webView.loadUrl("https://github.com/")
    }

    // Handle back button press to navigate WebView history
    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}