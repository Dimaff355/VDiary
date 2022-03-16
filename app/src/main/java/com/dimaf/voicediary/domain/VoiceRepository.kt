package com.dimaf.voicediary.domain

import androidx.lifecycle.LiveData

interface VoiceRepository {
    fun deleteVoice(voice: Voice)
    fun getVoiceList() : LiveData<List<Voice>>
    fun playVoice(voice: Voice)
    fun recordVoice() : Voice
    fun saveVoice (voice: Voice)
}