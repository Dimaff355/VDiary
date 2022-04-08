package com.dimaf.voicediary.domain

class DeleteVoiceUseCase (private val repository: VoiceRepository) {
    suspend fun deleteVoice (voice: Voice) {
        repository.deleteVoice(voice)
    }
}