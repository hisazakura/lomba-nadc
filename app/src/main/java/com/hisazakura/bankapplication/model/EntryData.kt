package com.hisazakura.bankapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EntryData(
    var name: String,
    var value: Float,
    var date : Long
){
    @PrimaryKey(autoGenerate = true)
    var id : Long? = null
}
