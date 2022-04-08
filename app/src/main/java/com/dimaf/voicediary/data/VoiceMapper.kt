package com.dimaf.voicediary.data

import com.dimaf.voicediary.domain.Voice

class VoiceMapper {
    fun mapVoiceToEntity (voice: Voice) = VoiceEntity(
        id = voice.id,
        date = voice.date,
        fileUrl = voice.fileUrl
    )

    fun mapEntityToVoice (voiceEntity: VoiceEntity) = Voice (
        id = voiceEntity.id,
        date = voiceEntity.date,
        fileUrl = voiceEntity.fileUrl
            )
    fun mapListEntityToListVoice (list : List<VoiceEntity>) = list.map {
        mapEntityToVoice(it)
    }
}