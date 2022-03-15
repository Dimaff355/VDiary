package com.dimaf.voicediary.domain

class DeleteVoiceUseCase (private val repository: VoiceRepository) {
    fun deleteVoice (voice: Voice) {
        repository.deleteVoice(voice)
    }
}