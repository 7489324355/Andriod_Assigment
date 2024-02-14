package com.example.module6application.Que9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.example.module6application.R
import com.example.module6application.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val topanimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottomanimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        binding.bg.startAnimation(topanimation)
        binding.logo.startAnimation(bottomanimation)

        Handler().postDelayed({
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }


}