package com.hisazakura.bankapplication.room

import androidx.room.*
import com.hisazakura.bankapplication.model.EntryData
import kotlinx.coroutines.flow.Flow

@Dao
interface EntryDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntryData(entryData: EntryData) : Long

    @Query("SELECT * FROM EntryData")
    fun getAllEntryData() : Flow<List<EntryData>>

    @Query("SELECT * FROM EntryData WHERE id = :id")
    fun getEntryDataById(id : Long) : Flow<EntryData>

    @Delete
    fun deleteEntryData(entryData: EntryData)
}