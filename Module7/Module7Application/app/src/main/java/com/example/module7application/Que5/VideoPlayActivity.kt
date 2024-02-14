package com.example.module7application.Que5



import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PowerManager
import android.widget.MediaController
import com.example.module7application.R
import com.example.module7application.databinding.ActivityVideoPlayBinding

class VideoPlayActivity : AppCompatActivity() {
    private lateinit var binding:ActivityVideoPlayBinding
    private var wakeLock: PowerManager.WakeLock? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityVideoPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val videoPath = "android.resource://com.example.module7application/" + R.raw.video
        binding.videoView.setVideoPath(videoPath)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(binding.videoView)
        binding.videoView.setMediaController(mediaController)

        // Set up Play/Pause button click listener
        binding.btnPlayPause.setOnClickListener {
            if (binding.videoView.isPlaying) {
                binding.videoView.pause()
                binding.btnPlayPause.text = "Play"
            } else {
                binding.videoView.start()
                binding.btnPlayPause.text = "Pause"
            }
        }

    }

}