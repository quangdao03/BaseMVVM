package com.example.basemvvm.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class LogoCategory(
    val category: String? = null,
    val items: List<LogoSubCategory>? = null
)

@Keep
data class LogoSubCategory(
    val type: String? = "",
    val category: String? = "",
    val data: List<LogoItem>? = null
)

@Keep
data class LogoItem(
    val name: String? = "",
    @SerializedName("image_url")
    val imageUrl: String? = ""
)
