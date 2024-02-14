package com.example.module6application.Que6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.module6application.R
import com.example.module6application.databinding.ActivityBlinkImageBinding

class BlinkImageActivity : AppCompatActivity() {
    private lateinit var binding:ActivityBlinkImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBlinkImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        rotateImage()

    }

    private fun rotateImage() {
        var animation = AnimationUtils.loadAnimation(this,R.anim.rotate)
        binding.imageView.startAnimation(animation)

    }
}