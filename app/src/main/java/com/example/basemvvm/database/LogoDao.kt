package com.example.basemvvm.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LogoDao {
    @Query("SELECT * FROM LogoModel")
    suspend fun getAll(): List<LogoModel>

    @Query("SELECT * FROM LogoModel WHERE category = :category")
    fun getCallById(category: String): List<LogoModel>

    @Insert
    fun insert(data: LogoModel): Long

    @Delete
    suspend fun delete(data: LogoModel)

    @Update
    suspend fun update(data: LogoModel)

    @Query("DELETE FROM LogoModel WHERE id = :id")
    fun deleteById(id: Long)

    @Query("SELECT * FROM LogoModel WHERE favourite = 1 AND category = :category")
    fun getFavouriteLogosByCategory(category: String): List<LogoModel>
}