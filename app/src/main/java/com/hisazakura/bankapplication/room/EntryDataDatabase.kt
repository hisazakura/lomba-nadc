package com.hisazakura.bankapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hisazakura.bankapplication.model.EntryData

@Database(
    entities = [
        EntryData::class
               ],
    version = 1,
    exportSchema = false
)
abstract class EntryDataDatabase : RoomDatabase(){
    abstract fun entryDataDao() : EntryDataDao

    companion object {
        @Volatile
        private var INSTANCE : EntryDataDatabase? = null
        fun getDatabase(context: Context) : EntryDataDatabase {
            return INSTANCE ?: synchronized(this){
                val instance =  Room.databaseBuilder(
                    context.applicationContext,
                    EntryDataDatabase::class.java,
                    "bank_application"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}