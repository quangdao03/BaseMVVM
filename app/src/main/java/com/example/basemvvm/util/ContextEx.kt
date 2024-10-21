package com.example.basemvvm.util

import android.app.AlertDialog
import android.content.Context

fun Context.showDialog(
    title: String,
    message: String,
    textOfNegativeButton: String? = null,
    textOfPositiveButton: String,
    positiveButtonFunction: () -> Unit,
    negativeButtonFunction: (() -> Unit)? = null
){
    val builder = AlertDialog.Builder(this)
    builder.setTitle(title)
    builder.setMessage(message)
    if (textOfNegativeButton != null) {
        builder.setNegativeButton(
            textOfNegativeButton
        ) { dialog, id ->
            if (negativeButtonFunction != null) {
                negativeButtonFunction()
            }
            dialog.dismiss()
        }
    }
    builder.setPositiveButton(
        textOfPositiveButton
    ) { dialog, id ->
        positiveButtonFunction()
        dialog.dismiss()
    }
    val alert = builder.create()
    alert.show()
}
