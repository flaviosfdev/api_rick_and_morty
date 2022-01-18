package com.flaviosf.rickandmorty.ui.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.flaviosf.rickandmorty.R

fun ImageView.load(context: Context,url: String, view: ImageView) {

    val requestOptions = RequestOptions()
        .placeholder(R.drawable.infinite_riks_rick)
        .error(R.drawable.infinite_riks_rick)

    Glide.with(context)
        .applyDefaultRequestOptions(requestOptions)
        .load(url)
        .into(view)
}