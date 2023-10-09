package com.exmple.module4.que_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.exmple.module4.R
import com.exmple.module4.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.webview.settings.javaScriptEnabled = true

        // Set up WebViewClient to handle page navigation within the WebView
        binding.webview.webViewClient = WebViewClient()
        // Set up WebChromeClient to handle progress and titles (optional)
        binding.webview.webChromeClient = WebChromeClient()

        // Load Google URL by default
        loadUrl("https://www.google.com")

        // Handle Back button click
        binding.backButton.setOnClickListener {
            if (binding.webview.canGoBack()) {
                binding.webview.goBack()
            }
        }

        // Handle Forward button click
        binding.forwardButton.setOnClickListener {
            if (binding.webview.canGoForward()) {
                binding.webview.goForward()
            }
        }
    }

    private fun loadUrl(url: String) {
       binding.webview.loadUrl(url)
    }
}