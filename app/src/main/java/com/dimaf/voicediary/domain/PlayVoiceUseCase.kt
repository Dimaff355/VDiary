package com.dimaf.voicediary.domain

class PlayVoiceUseCase (private val repository: VoiceRepository) {
    fun playVoice(voice: Voice) {
        repository.playVoice(voice)
    }
}