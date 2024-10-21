package com.example.basemvvm.di

import android.app.Application
import com.example.basemvvm.util.Data
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(networkModule, viewModelModule, DBModule))
        }
        Data.initInstance(this)
    }

}