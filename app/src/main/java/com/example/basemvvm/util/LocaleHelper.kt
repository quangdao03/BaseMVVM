package com.example.basemvvm.util

import android.content.Context
import android.os.LocaleList
import java.util.Locale

object LocaleHelper {

    fun changeTo(languageCode: String, context: Context): Context {
        val config = context.resources.configuration
        val localeList = LocaleList(Locale(languageCode))
        LocaleList.setDefault(localeList)
        config.setLocales(localeList)
        return context.createConfigurationContext(config)
    }
}
