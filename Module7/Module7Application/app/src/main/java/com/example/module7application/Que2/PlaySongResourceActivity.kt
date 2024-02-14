package com.example.module7application.Que2

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ProgressBar
import com.example.module7application.Que3.PlayMobileMemoryActivity
import com.example.module7application.R
import com.example.module7application.databinding.ActivityPlayMobileMemoryBinding
import com.example.module7application.databinding.ActivityPlaySongResourceBinding
import java.util.Timer
import java.util.TimerTask

class PlaySongResourceActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPlaySongResourceBinding
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var progressBar: ProgressBar
    private var isPlaying = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPlaySongResourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.next.setOnClickListener {
            var intent = Intent(this,PlayMobileMemoryActivity::class.java)
            startActivity(intent)
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.tera)
        progressBar = binding.progressBar

        setupMediaPlayer()
        setupClickListeners()
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
    private fun showPlayImage() {
        binding.play.visibility = View.VISIBLE
        binding.stop.visibility = View.GONE
    }

    private fun showStopImage() {
        binding.play.visibility = View.GONE
        binding.stop.visibility = View.VISIBLE
    }
    private fun setupMediaPlayer() {
        mediaPlayer.setOnCompletionListener {
            // Reset the MediaPlayer when playback is completed
            isPlaying = false
            showPlayImage()
            mediaPlayer.seekTo(0)
            progressBar.progress = 0
        }

        // Update progress bar as the media is being played
        mediaPlayer.setOnPreparedListener {
            progressBar.max = mediaPlayer.duration
            progressBar.progress = 0
        }

        // Update progress bar while playing
        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    if (isPlaying) {
                        progressBar.progress = mediaPlayer.currentPosition
                    }
                }
            }
        }, 0, 1000)
        binding.progressBar.setOnTouchListener { _, event ->
            onProgressBarClick(event)
            true
        }

    }

    private fun onProgressBarClick(event: MotionEvent) {
        val newPosition = (event.x / progressBar.width) * progressBar.max
        mediaPlayer.seekTo(newPosition.toInt())
        progressBar.progress = newPosition.toInt()
    }

    private fun setupClickListeners() {
        binding.play.setOnClickListener { onPlayButtonClick() }
        binding.stop.setOnClickListener { onStopButtonClick() }

    }
    private fun onPlayButtonClick() {
        if (isPlaying) {
            mediaPlayer.pause()
            showPlayImage()
        } else {
            mediaPlayer.start()
            showStopImage()
        }
        isPlaying = !isPlaying
    }

    private fun onStopButtonClick() {
        mediaPlayer.pause()
        showPlayImage()
        isPlaying = false
//        progressBar.progress = 0
    }

    }




