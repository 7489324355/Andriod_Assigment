package com.example.module6application.Que8

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import com.example.module6application.R
import com.example.module6application.databinding.ActivityProgressFrameBinding

class ProgressFrameActivity : AppCompatActivity() {
    private lateinit var binding:ActivityProgressFrameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityProgressFrameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var ad= AnimationDrawable()
        var frame= resources.getDrawable(R.drawable.img,null)
        var frame1= resources.getDrawable(R.drawable.moms,null)
        var frame2= resources.getDrawable(R.drawable.yum,null)

        ad.addFrame(frame,200)
        ad.addFrame(frame1,300)
        ad.addFrame(frame2,200)
        binding.imageView.background=ad
        binding.startButton.setOnClickListener {

            ad.start()
        }
        binding.stop.setOnClickListener {
            ad.stop()
        }
    }


}