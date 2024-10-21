package com.example.basemvvm.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.util.Base64
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.example.basemvvm.R
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily

fun ShapeableImageView.setCornerRadius(
    topLeft: Float = 0f,
    topRight: Float = 0f,
    bottomRight: Float = 0f,
    bottomLeft: Float = 0f
) {
    shapeAppearanceModel = shapeAppearanceModel
        .toBuilder()
        .setTopLeftCorner(CornerFamily.ROUNDED, topLeft)
        .setTopRightCorner(CornerFamily.ROUNDED, topRight)
        .setBottomRightCorner(CornerFamily.ROUNDED, bottomRight)
        .setBottomLeftCorner(CornerFamily.ROUNDED, bottomLeft)
        .build()
}

fun ShapeableImageView.setCornerRadius(radius: Float = 0f) {
    shapeAppearanceModel = shapeAppearanceModel
        .toBuilder()
        .setTopLeftCorner(CornerFamily.ROUNDED, radius)
        .setTopRightCorner(CornerFamily.ROUNDED, radius)
        .setBottomRightCorner(CornerFamily.ROUNDED, radius)
        .setBottomLeftCorner(CornerFamily.ROUNDED, radius)
        .build()
}

fun ImageView.loadImage(@DrawableRes resId: Int) {
    Glide.with(context)
        .load(resId)
        .into(this)
}

fun ImageView.loadImage(link: String, onImageLoaded: (() -> Unit)? = null) {
    Glide.with(context)
        .load(link)
        .placeholder(R.color.white)
        .listener(object : RequestListener<Drawable?> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable?>,
                isFirstResource: Boolean
            ): Boolean {
                onImageLoaded?.invoke()
                return false
            }

            override fun onResourceReady(
                resource: Drawable,
                model: Any,
                target: Target<Drawable?>?,
                dataSource: DataSource,
                isFirstResource: Boolean
            ): Boolean {
                onImageLoaded?.invoke()
                return false
            }
        })
        .into(this)
}

fun ImageView.loadImageProgressBar(link: String, hideProgress: () -> Unit) {
    Glide.with(context)
        .load(link)
        .listener(object : RequestListener<Drawable?> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable?>,
                isFirstResource: Boolean
            ): Boolean {
                hideProgress.invoke()
                return false
            }

            override fun onResourceReady(
                resource: Drawable,
                model: Any,
                target: Target<Drawable?>?,
                dataSource: DataSource,
                isFirstResource: Boolean
            ): Boolean {
                hideProgress.invoke()
                return false
            }
        })
        .into(this)
}

fun ImageView.loadBase64Image(base64: String) {
    val decodedString = Base64.decode(base64, Base64.DEFAULT)
    val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
    this.setImageBitmap(decodedByte)
}

fun getBitmapFrom(context: Context, url: String?, onLoaded: (Bitmap) -> Unit) {
    Glide.with(context)
        .asBitmap()
        .load(url)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                onLoaded(resource)
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }

        })
}