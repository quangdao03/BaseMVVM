package com.example.basemvvm.di

import android.content.Context
import androidx.room.Room
import com.example.basemvvm.database.RoomMyDatabase

import org.koin.dsl.module

val DBModule = module {
    single { provideDatabase(get()) }
    single { provideLogoDao(get()) }
    single { provideDraftDao(get()) }
}

private fun provideDatabase(context: Context): RoomMyDatabase {
    return Room.databaseBuilder(
        context.applicationContext,
        RoomMyDatabase::class.java,
        RoomMyDatabase.DATABASE_NAME
    )
        .fallbackToDestructiveMigration()
        .build()
}

private fun provideLogoDao(database: RoomMyDatabase) = database.logoDao()

private fun provideDraftDao(database: RoomMyDatabase) = database.getDraftDAO()
