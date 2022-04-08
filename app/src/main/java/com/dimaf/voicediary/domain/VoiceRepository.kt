package com.dimaf.voicediary.domain

import androidx.lifecycle.LiveData

interface VoiceRepository {
    suspend fun deleteVoice(voice: Voice)
    fun getVoiceList() : LiveData<List<Voice>>
    suspend fun getVoice (voice: Voice)
    suspend fun saveVoice (voice : Voice)
}