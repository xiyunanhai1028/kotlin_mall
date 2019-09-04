package com.kotlin.baselibrary.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.kotlin.baselibrary.R

/**
 *    author : dufeihu
 *    date   : 2019/9/3 11:20
 *    desc   :
 */
class GlideUtils {
    fun loadImage(context: Context, url: String, imageView: ImageView) {
        val requestOptions = RequestOptions()
        requestOptions.centerCrop()
        Glide.with(context).load(url).apply(requestOptions).into(imageView)
    }

    fun loadImageFitCenter(context: Context, url: String, imageView: ImageView) {
        val requestOptions = RequestOptions()
        requestOptions.fitCenter()
        Glide.with(context).load(url).apply(requestOptions).into(imageView)
    }

    /**
     * 当fragment或者activity失去焦点或者destroyed的时候，Glide会自动停止加载相关资源，确保资源不会被浪费
     */
    fun loadUrlImage(context: Context, url: String, imageView: ImageView) {
        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.abc_ab_share_pack_mtrl_alpha)
        requestOptions.error(R.drawable.abc_ab_share_pack_mtrl_alpha)
        requestOptions.centerCrop()
        Glide.with(context).load(url).apply(requestOptions).into(object : SimpleTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                imageView.setImageDrawable(resource)
            }

        })
    }
}