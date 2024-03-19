package com.example.testproject.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.testproject.CustomChromeClient
import com.example.testproject.R
import com.example.testproject.encoding
import com.example.testproject.htmlFun
import com.example.testproject.mimeType


class VideoFragment : Fragment(R.layout.fragment_video) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webView: WebView = requireActivity().findViewById(R.id.webview)
        val customView: FrameLayout = requireActivity().findViewById(R.id.custom_view)

        webView.apply {
            settings.javaScriptEnabled = true
            loadData(htmlFun, mimeType, encoding)
            webViewClient = WebViewClient()
            webChromeClient = CustomChromeClient(customView, webView)
        }
    }
}