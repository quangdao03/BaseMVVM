package com.example.basemvvm.util

import java.util.Locale

fun String.capitalizeWords(): String = split(" ").joinToString(" ") { str ->
    str.lowercase()
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}