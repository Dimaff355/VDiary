package com.dimaf.voicediary.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface VoiceDAO {
   // функция удаления записи
    @Delete
    suspend fun deleteVoiceFromDb (voice: VoiceEntity)

    // функция запрашивания списка записей
    @Query ("SELECT * FROM voices_table")
    fun getVoiceList() : LiveData<List<VoiceEntity>>

    // функция запрашивания одного объекта VoiceEntiry по id (пригодится для проигрывания)
    @Query ("SELECT * FROM voices_table WHERE id=:id LIMIT 1")
    suspend fun getVoiceFromDbById (id : Int) : VoiceEntity

    // функция добавления новой записи в БД
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveVoiceToDb(voice: VoiceEntity)
}