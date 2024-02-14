package com.example.module6application.Que7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.module6application.R
import com.example.module6application.databinding.ActivityTrasalateBinding

class TrasalateActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTrasalateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTrasalateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var animation = AnimationUtils.loadAnimation(this,R.anim.trasalate)
        binding.imageView.startAnimation(animation)

        var animation1 : Animation = AnimationUtils.loadAnimation(this,R.anim.zoomin)
        binding.imageView1.startAnimation(animation1)
//
//        //ZoomOut
        var animation2 : Animation = AnimationUtils.loadAnimation(this,R.anim.zoomout)
        binding.imageView2.startAnimation(animation2)

    }
}