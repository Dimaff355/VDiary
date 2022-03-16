package com.dimaf.voicediary.domain

class RecordVoiceUseCase (private val repository: VoiceRepository) {
    fun recordVoice() : Voice {
        return repository.recordVoice()
    }
}