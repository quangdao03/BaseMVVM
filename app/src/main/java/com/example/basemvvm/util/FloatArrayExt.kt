package com.example.basemvvm.util

import android.graphics.RectF
import android.util.Log
import kotlin.math.abs
import kotlin.math.round

fun FloatArray.top() = this[1]

fun FloatArray.left() = this[0]

fun FloatArray.bottom() = this[5]

fun FloatArray.right() = this[2]

fun FloatArray.width() = abs(right() - left())

fun FloatArray.height() = abs(bottom() - top())

fun FloatArray.toRectF(rectF: RectF) {
    rectF.set(
        Float.POSITIVE_INFINITY,
        Float.POSITIVE_INFINITY,
        Float.NEGATIVE_INFINITY,
        Float.NEGATIVE_INFINITY
    )
    for (i in 1 until size step 2) {
        val x = round(this[i - 1] * 10) / 10f
        val y = round(this[i] * 10) / 10f
        rectF.left = if (x < rectF.left) x else rectF.left
        rectF.top = if (y < rectF.top) y else rectF.top
        rectF.right = if (x > rectF.right) x else rectF.right
        rectF.bottom = if (y > rectF.bottom) y else rectF.bottom
    }
    rectF.sort()
}

fun FloatArray.toRectF(): RectF {
    val rect = RectF()
    toRectF(rect)
    return rect
}
