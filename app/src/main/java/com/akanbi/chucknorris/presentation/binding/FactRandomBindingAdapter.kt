package com.akanbi.chucknorris.presentation.binding

import android.view.View
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

@BindingAdapter("app:loadData")
fun loadData(webView: WebView, text: String) {
    val html = "<html><body><p align=\"justify\" style=\"font-size:10px\">${formatTextForWebView(text)}</p></body></html>";
    webView.loadData(html, "text/html", "utf-8")
}

@BindingAdapter("android:visibility")
fun showLoadFactRandom(progressBar: ProgressBar, text: String) {
    progressBar.visibility = if (formatTextForWebView(text).isBlank()) View.VISIBLE else View.GONE
}

private fun formatTextForWebView(text: String): String {
    return when (text) {
        "null" -> ""
        else -> text
    }
}