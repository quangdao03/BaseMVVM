package com.example.basemvvm.util

import android.content.Context
import android.content.SharedPreferences

class Data {
    companion object {
        private const val V040_LOAN = "V040_LOAN"
        private const val IS_RATED = "rated"
        private const val COUNTS = "counts"
        private const val OPEN2 = "open2"

        private lateinit var instanceSharePref: SharedPreferences

        fun initInstance(context: Context) {
            instanceSharePref =
                context.getSharedPreferences(V040_LOAN, Context.MODE_PRIVATE)
        }

        fun isRated(): Boolean {
            return instanceSharePref.getBoolean(IS_RATED, false)
        }

        fun getCountOpenApp(): Int {
            return instanceSharePref.getInt(COUNTS, 1)
        }

        fun increaseCountOpenApp() {
            val editor = instanceSharePref.edit()
            editor.putInt(COUNTS, instanceSharePref.getInt(COUNTS, 1) + 1)
            editor.apply()
        }

        fun forceRated() {
            val editor = instanceSharePref.edit()
            editor.putBoolean(IS_RATED, true)
            editor.apply()
        }

        fun language2() {
            val editor = instanceSharePref.edit()
            editor.putBoolean(OPEN2, true)
            editor.apply()
        }

        fun language(): Boolean {
            return instanceSharePref.getBoolean(OPEN2, false)
        }

        fun getString(key: String, value: String): String? {
            return instanceSharePref.getString(key, value)
        }

        fun setString(key: String, value: String) {
            instanceSharePref.edit().putString(key, value).apply()
        }

        fun setBool(key: String, value: Boolean) {
            instanceSharePref.edit().putBoolean(key, value).apply()
        }

        fun getBool(key: String, value: Boolean): Boolean {
            return instanceSharePref.getBoolean(key, value)
        }

    }

}