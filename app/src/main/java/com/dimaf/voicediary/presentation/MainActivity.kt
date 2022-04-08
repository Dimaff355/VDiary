package com.dimaf.voicediary.presentation

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.dimaf.voicediary.databinding.ActivityMainBinding
import com.dimaf.voicediary.domain.Voice
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val mediaRecorderHelper = MediaRecorderHelper()
    val mediaPlayerHelper = MediaPlayerHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model = ViewModelVoice(application)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var currentFileName = ""
        var currentDateTime = LocalDateTime.now()


        binding.buttonStart.setOnClickListener {
            checkPermissions()
            try {
                val dateTimeNow = LocalDateTime.now()
                val name = "${externalCacheDir?.absolutePath}/${dateTimeNow.toString()}.3gp"
                mediaRecorderHelper.recorderStart(name, this)
                currentFileName = name
                currentDateTime = dateTimeNow
            } catch (e: Exception) {
            }
        }
        binding.buttonStop.setOnClickListener {
            mediaRecorderHelper.recorderStop()
            val currentVoice = Voice (0, currentDateTime.toString(), currentFileName)
            if (currentFileName != "") {
                model.saveVoice(currentVoice)
                currentFileName = ""
                currentDateTime = LocalDateTime.now()
            }

        }

        binding.buttonPlay.setOnClickListener {
            mediaPlayerHelper.startPlaying("filename") // потом поправлю
            TODO()
        }

    }
    private fun checkPermissions() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            val permissions = arrayOf(
                android.Manifest.permission.RECORD_AUDIO,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
            ActivityCompat.requestPermissions(this, permissions, 0)
        }
    }

}