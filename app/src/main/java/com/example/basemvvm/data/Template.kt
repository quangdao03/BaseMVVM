package com.example.basemvvm.data

import com.google.gson.annotations.SerializedName

data class TemplateResponse(
    @SerializedName("type") val type: String,
    @SerializedName("data") val data: Data,
    @SerializedName("image_url") val imageUrl: String
)

data class Data(
    @SerializedName("layers") val layers: List<Layer>
)

data class Layer(
    @SerializedName("type") val type: String,
    @SerializedName("content") val content: String?,
    @SerializedName("position") val position: Position,
    @SerializedName("size") val size: Size,
    @SerializedName("style") val style: Style?,
    @SerializedName("image_url") val imageUrl: String?,
    var isHidden: Boolean = false,
    var isClicked: Boolean = false,
)

data class Position(
    @SerializedName("x") val x: Double,
    @SerializedName("y") val y: Double
)

data class Size(
    @SerializedName("width") val width: Double,
    @SerializedName("height") val height: Double
)

data class Style(
    @SerializedName("color") val color: String,
    @SerializedName("font") val font: String,
    @SerializedName("fontSize") val fontSize: Double
)
