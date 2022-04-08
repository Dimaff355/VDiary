package com.dimaf.voicediary.presentation

import android.media.MediaPlayer
import android.util.Log
import java.io.IOException

class MediaPlayerHelper {
    private var player : MediaPlayer? =  null
    private var isPlaying = false

    fun startPlaying(source : String) {
        if (!isPlaying) {
            try {
                player = MediaPlayer().apply {
                    setDataSource(source)
                    prepare()
                    start()
                }
                isPlaying = true
            } catch (e: IOException) {
                Log.e("MyLog", "prepare() failed")
            }
        }
    }

    fun stopPlaying() {
        player?.release()
        player = null
        isPlaying = false
    }
}