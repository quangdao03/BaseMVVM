package com.example.basemvvm.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.os.SystemClock
import android.view.View

abstract class TapListener : View.OnClickListener {
    companion object {
        private const val DEBOUNCE = 800L
        fun Context.findActivity(): Activity? {
            var context = this
            while (context is ContextWrapper) {
                if (context is Activity) return context
                context = context.baseContext
            }
            return null
        }
    }

    private var lastClickMillis: Long = 0
    private var now = 0L

    override fun onClick(v: View?) {
        now = SystemClock.elapsedRealtime()
        if (now - lastClickMillis > DEBOUNCE)
            onTap(v)
        lastClickMillis = now
    }

    abstract fun onTap(v: View?)
}