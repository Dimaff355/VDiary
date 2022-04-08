package com.dimaf.voicediary.domain

class SaveVoiceUseCase (private val repository: VoiceRepository) {
    suspend fun saveVoice (voice : Voice) {
        repository.saveVoice(voice)
    }
}