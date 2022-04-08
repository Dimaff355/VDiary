package com.dimaf.voicediary.presentation

import android.content.Context
import android.media.MediaRecorder
import android.util.Log
import android.widget.Toast
import java.io.IOException

class MediaRecorderHelper () {
    private var recorder : MediaRecorder? = null
    private var isRecording = false


    fun recorderStart (name : String, context: Context) {
        if (!isRecording) {
            recorder = MediaRecorder().apply {
                try {
                    setAudioSource(MediaRecorder.AudioSource.MIC)
                    setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                    setOutputFile(name)
                    setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                    prepare()
                    start()
                    Toast.makeText(context, name, Toast.LENGTH_LONG).show()
                } catch (e: IOException) {
                    Log.e("MyLog", "start failed")
                }
                isRecording = true
            }

        }
    }

    fun recorderReset () {
        if (isRecording) {
            recorder?.reset()
        }
    }

    fun recorderStop () {
        if (isRecording) {
            recorder?.stop()
            isRecording = false
            recorder?.release()
            recorder = null
            Log.i("MyLog", "Stopped")
        }
    }





}