package com.example.basemvvm.util

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.core.os.BundleCompat

inline fun <reified T : Parcelable> Bundle.getParcel(key: String): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        BundleCompat.getParcelable(this, key, T::class.java)
    } else {
        getParcelable(key)
    }
}
