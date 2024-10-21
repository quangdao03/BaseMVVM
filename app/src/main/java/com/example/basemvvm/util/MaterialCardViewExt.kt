package com.example.basemvvm.util

import com.google.android.material.card.MaterialCardView
import com.google.android.material.shape.CornerFamily

fun MaterialCardView.setCornerRadius(
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

fun MaterialCardView.setCornerRadius(radius: Float = 0f) {
    setCornerRadius(radius, radius, radius, radius)
}
