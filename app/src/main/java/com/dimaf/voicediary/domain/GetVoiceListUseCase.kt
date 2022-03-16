package com.dimaf.voicediary.domain

import androidx.lifecycle.LiveData

class GetVoiceListUseCase (private val repository: VoiceRepository) {
    fun getVoiceList() : LiveData<List<Voice>> {
        return repository.getVoiceList()
    }
}