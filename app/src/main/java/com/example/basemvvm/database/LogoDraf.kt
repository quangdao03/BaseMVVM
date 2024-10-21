package com.example.basemvvm.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class LogoDraft(
    val thumb: String,
    val layer: String,
    val ratio: Float,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
): Parcelable
