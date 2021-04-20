package com.akanbi.commonandroid

import android.widget.ImageView
import com.bumptech.glide.Glide

fun showContentOnImageView(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
            .load(url)
            .into(imageView)
}