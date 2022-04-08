package com.dimaf.voicediary.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.dimaf.voicediary.data.VoiceRepositoryImpl
import com.dimaf.voicediary.domain.*
import kotlinx.coroutines.launch

class ViewModelVoice (application: Application) : AndroidViewModel (application) {
    private val repository = VoiceRepositoryImpl(application)
    private val getVoiceListUseCase = GetVoiceListUseCase(repository)
    private val deleteVoiceUseCase = DeleteVoiceUseCase(repository)
    private val voiceList = getVoiceListUseCase.getVoiceList()
    private val saveVoiceUseCase = SaveVoiceUseCase(repository)
    private val playVoiceUseCase = GetVoiceUseCase(repository)

    fun deleteVoice (voice: Voice) {
        viewModelScope.launch {
            deleteVoiceUseCase.deleteVoice(voice)
        }
    }

    fun saveVoice (voice: Voice) {
        viewModelScope.launch {
            saveVoiceUseCase.saveVoice(voice)
        }
    }

    fun getVoice (voice: Voice) {
        viewModelScope.launch {
            playVoiceUseCase.getVoice(voice)
        }
    }


}