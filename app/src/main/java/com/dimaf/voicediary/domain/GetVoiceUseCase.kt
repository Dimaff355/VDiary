package com.dimaf.voicediary.domain

class GetVoiceUseCase (private val repository: VoiceRepository) {
    suspend fun getVoice (voice: Voice) {
        repository.getVoice(voice)
    }
}