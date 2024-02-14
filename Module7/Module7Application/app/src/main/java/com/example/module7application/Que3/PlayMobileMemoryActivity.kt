package com.example.module7application.Que3

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.example.module7application.Que4.PlaySongServerActivity
import com.example.module7application.R
import com.example.module7application.databinding.ActivityPlayMobileMemoryBinding
import java.util.Timer
import java.util.TimerTask

class PlayMobileMemoryActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPlayMobileMemoryBinding
    private var mediaPlayer: MediaPlayer? = null
    private var isPlaying = false

    private val pickSongLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.data?.let { uri ->
                // Use the selected file URI to play the song
                playSong(uri)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPlayMobileMemoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.next.setOnClickListener {
            var intent = Intent(this,PlaySongServerActivity::class.java)
            startActivity(intent)
        }

        binding.play.setOnClickListener {
          pickSong()
        }
        setupClickListeners()

    }
    override fun onDestroy() {
        mediaPlayer?.release()
        super.onDestroy()
    }

    private fun pickSong() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "audio/*"
        }
        pickSongLauncher.launch(intent)
    }
    private fun playSong(uri: Uri) {
        mediaPlayer?.release()

        mediaPlayer = MediaPlayer().apply {
            setDataSource(this@PlayMobileMemoryActivity, uri)
            prepare()
            start()
            this@PlayMobileMemoryActivity.isPlaying = true
            showPlayImage()
            mediaPlayer?.seekTo(0)
            binding.progressBar.progress = 0

        }
        mediaPlayer!!.setOnPreparedListener {
            binding.progressBar.max = mediaPlayer!!.duration
            binding.progressBar.progress = 0
        }

        // Update progress bar while playing
        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    if (isPlaying) {
                        binding.progressBar.progress = mediaPlayer!!.currentPosition
                    }
                }
            }
        }, 0, 1000)
        binding.progressBar.setOnTouchListener { _, event ->
            onProgressBarClick(event)
            true
        }
        showStopImage()
        binding.play.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
            } else {
                mediaPlayer?.start()
            }
            showStopImage()
        }
    }

    private fun showPlayImage() {
        binding.play.visibility = View.VISIBLE
        binding.stop.visibility = View.GONE
    }

    private fun showStopImage() {
        binding.play.visibility = View.GONE
        binding.stop.visibility = View.VISIBLE
    }
    private fun setupClickListeners() {

        binding.stop.setOnClickListener { onStopButtonClick() }
    }

    private fun onStopButtonClick() {
        mediaPlayer!!.pause()
        showPlayImage()
        isPlaying = false
//        progressBar.progress = 0
    }
    private fun onProgressBarClick(event: MotionEvent) {
        val newPosition = (event.x / binding.progressBar.width) * binding.progressBar.max
        mediaPlayer!!.seekTo(newPosition.toInt())
        binding.progressBar.progress = newPosition.toInt()
    }



}