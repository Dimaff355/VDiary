package com.dimaf.voicediary.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(VoiceEntity::class), version = 1, exportSchema = false)
abstract class VoiceDatabase : RoomDatabase() {
    companion object {
        private var db : VoiceDatabase? = null
        private const val DB_NAME = "voices.db"
        private val LOCK = Any()

        fun getInstance(application: Application) : VoiceDatabase {
            db?.let { return it }
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        application,
                        VoiceDatabase::class.java,
                        DB_NAME
                    ).build()
                db = instance
                return instance
            }
        }
    }
    abstract fun voiceDao() : VoiceDAO
}
