package com.exmple.module4.que_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exmple.module4.R
import com.exmple.module4.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var fragment = LoginFragment()

        var manager = supportFragmentManager
        var transaction = manager.beginTransaction()
        transaction.add(R.id.splash,fragment)
        transaction.commit()
    }
}