package com.example.basemvvm.util

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object SharePref {
    const val LANGUAGE = "LANGUAGE"
    const val LANGUAGE_NAME = "LANGUAGE_NAME"
    const val RATED = "RATED"
    const val FIRST_OPEN_APP = "FIRST_OPEN_APP"
    const val DEVICE_LANGUAGE = "DEVICE_LANGUAGE"
    private const val PREF_NAME = "data"

    fun getString(context: Context, key: String, defValue: String = ""): String {
        val pre = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return pre.getString(key, defValue) ?: defValue
    }

    fun saveString(context: Context, key: String, value: String) {
        val pre = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = pre.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getInt(context: Context, key: String, defValue: Int = 0): Int {
        val pre = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return pre.getInt(key, defValue)
    }

    fun saveInt(context: Context, key: String, value: Int) {
        val pre = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = pre.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getLong(context: Context, key: String, defValue: Long = 0): Long {
        val pre = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return pre.getLong(key, defValue)
    }

    fun saveLong(context: Context, key: String, value: Long) {
        val pre = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = pre.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    fun getBoolean(context: Context, key: String, defValue: Boolean = false): Boolean {
        val pre = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return pre.getBoolean(key, defValue)
    }

    fun saveBoolean(context: Context, key: String, value: Boolean) {
        val pre = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = pre.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun saveListInt(context: Context, key: String, value: List<Int>) {
        val pre = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = pre.edit()
        editor.putString(key, Gson().toJson(value))
        editor.apply()
    }

    fun getListInt(context: Context, key: String): List<Int> {
        val pre = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val dataString = pre.getString(key, "") ?: ""
        if (dataString.isBlank()) return listOf()
        val type = object : TypeToken<List<Int>>() {}.type
        val data = Gson().fromJson<List<Int>>(dataString, type)
        return data
    }
}
