package com.dimaf.voicediary.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "voices_table")
data class VoiceEntity (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val date : String,
    val fileUrl : String
        )