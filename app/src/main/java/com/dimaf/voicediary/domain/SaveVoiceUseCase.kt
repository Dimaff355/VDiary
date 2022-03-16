package com.dimaf.voicediary.domain

class SaveVoiceUseCase (private val repository: VoiceRepository) {
    fun saveVoice (voice: Voice) {
        repository.saveVoice(voice)
    }
}