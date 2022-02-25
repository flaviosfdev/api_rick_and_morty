package com.flaviosf.rickandmorty.ui.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.flaviosf.rickandmorty.R

fun ImageView.load(context: Context, url: String, view: ImageView) {

    val requestOptions = RequestOptions()
        .placeholder(R.drawable.ic_launcher_background)
        .error(R.drawable.ic_launcher_foreground)

    Glide.with(context)
        .applyDefaultRequestOptions(requestOptions)
        .load(url)
        .into(view)

}