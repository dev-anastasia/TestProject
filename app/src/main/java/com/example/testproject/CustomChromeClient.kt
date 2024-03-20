package com.example.testproject

import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.widget.FrameLayout

class CustomChromeClient(
    private var fullscreenContainer: ViewGroup,
    private var webView: ViewGroup
) : WebChromeClient() {

    private var customView: View? = null

    override fun onShowCustomView(view: View, callback: CustomViewCallback) {
        super.onShowCustomView(view, callback)
        if (customView != null) {
            onHideCustomView()
            return
        }
        customView = view
        webView.visibility = View.GONE
        fullscreenContainer.apply {
            visibility = View.VISIBLE
            addView(
                customView, FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }
    }

    override fun onHideCustomView() {
        super.onHideCustomView()
        webView.visibility = View.VISIBLE
        fullscreenContainer.visibility = View.GONE
        fullscreenContainer.removeView((customView))
        customView = null
    }
}