package com.dimaf.voicediary.data

import androidx.lifecycle.LiveData
import com.dimaf.voicediary.domain.Voice
import com.dimaf.voicediary.domain.VoiceRepository

object VoiceRepositoryImpl : VoiceRepository {
    override fun deleteVoice(voice: Voice) {
        TODO("Not yet implemented")
    }

    override fun getVoiceList(): LiveData<List<Voice>> {
        TODO("Not yet implemented")
    }

    override fun playVoice(voice: Voice) {
        TODO("Not yet implemented")
    }

    override fun recordVoice(): Voice {
        TODO("Not yet implemented")
    }

    override fun saveVoice(voice: Voice) {
        TODO("Not yet implemented")
    }
}