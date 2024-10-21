package com.example.basemvvm.data

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Keep
data class ShapeModel(
    @SerializedName("type")
    val type: String?,
    @SerializedName("data")
    val data: List<ShapeDetailItem>?
): Parcelable

@Parcelize
@Keep
data class ShapeDetailItem(
    @SerializedName("name")
    val name: String?,
    @SerializedName("image_url")
    val image: String?,
): Parcelable