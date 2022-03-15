package com.dimaf.voicediary.domain

interface VoiceRepository {
    fun deleteVoice(voice: Voice)
}