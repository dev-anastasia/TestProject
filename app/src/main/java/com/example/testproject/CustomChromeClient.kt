package com.example.testproject

import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.widget.LinearLayout

class CustomChromeClient(private var customView: ViewGroup, private var webView: ViewGroup) :
    WebChromeClient() {

    override fun onShowCustomView(view: View, callback: CustomViewCallback) {
        super.onShowCustomView(view, callback)
        webView.visibility = View.GONE
        customView.visibility = View.VISIBLE
        customView.addView(view)
    }

    override fun onHideCustomView() {
        super.onHideCustomView()
        webView.visibility = View.VISIBLE
        customView.visibility = View.GONE
    }
}