package com.example.basemvvm.data

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Keep
data class Category(
    @SerializedName("category")
    val category: String?,
    @SerializedName("items")
    val items: List<CategoryItem>?
): Parcelable

@Parcelize
@Keep
data class CategoryItem(
    @SerializedName("name")
    val name: String?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("image_url")
    val image: String?,
): Parcelable
