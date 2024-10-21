package com.example.basemvvm.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class LogoModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "pathImage") val pathImage: String? = null,
    @ColumnInfo(name = "favourite") val favourite: Boolean = false,
    @ColumnInfo(name = "category") val category: String? = null
) : Parcelable