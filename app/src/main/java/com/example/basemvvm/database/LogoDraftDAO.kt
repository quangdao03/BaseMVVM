package com.example.basemvvm.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface LogoDraftDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDraft(draft: LogoDraft)

    @Update
    fun updateDraft(draft: LogoDraft)

    @Query("select * from LogoDraft")
    fun getAllDraft(): List<LogoDraft>

    @Delete
    fun deleteDraft(draft: LogoDraft)
}
