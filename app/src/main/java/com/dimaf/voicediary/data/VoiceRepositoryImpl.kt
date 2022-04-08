package com.dimaf.voicediary.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.dimaf.voicediary.domain.Voice
import com.dimaf.voicediary.domain.VoiceRepository

class VoiceRepositoryImpl (application: Application) : VoiceRepository {

    private val voiceDao = VoiceDatabase.getInstance(application).voiceDao()
    private val mapper = VoiceMapper()

    override suspend fun deleteVoice(voice: Voice) {
        voiceDao.deleteVoiceFromDb(mapper.mapVoiceToEntity(voice))
    }

    override fun getVoiceList(): LiveData<List<Voice>> = Transformations.map(
        voiceDao.getVoiceList()
    ) {
            mapper.mapListEntityToListVoice(it)
        }

    override suspend fun getVoice(voice: Voice) {
        voiceDao.getVoiceFromDbById(voice.id)
    }

    override suspend fun saveVoice(voice: Voice) {
        voiceDao.saveVoiceToDb(mapper.mapVoiceToEntity(voice))
    }
}