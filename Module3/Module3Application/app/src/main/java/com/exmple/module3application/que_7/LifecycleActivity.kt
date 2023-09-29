package com.exmple.module3application.que_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exmple.module3application.R
import com.exmple.module3application.databinding.ActivityLifecycleBinding

class LifecycleActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLifecycleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLifecycleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvActivity.text="In Android app development, an \"activity\" represents a single screen with a user interface. Activities are fundamental building blocks of Android apps and are used to interact with the user. Each activity typically corresponds to a specific screen or a particular interaction within the app. Activities can range from simple screens like login forms to more complex ones like maps, web browsers, or even games."
       binding.tvLifecycle.text="onCreate(): This method is called when the activity is first created. It is where you typically perform one-time initialization tasks, such as setting up the user interface and preparing resources.\n" +
               "\n" +
               "onStart(): Called when the activity is about to become visible but not yet interactive. This is where you can prepare to start interacting with the user.\n" +
               "\n" +
               "onResume(): Called when the activity becomes visible and is ready to interact with the user. It's a good place to start animations, play media, or acquire resources that should be active when the user is interacting with the activity.\n" +
               "\n" +
               "onPause(): Called when the activity is partially obscured by another activity or when it's about to go into the background. You should pause any ongoing activities or releases resources that are not needed while the activity is not in the foreground.\n" +
               "\n" +
               "onStop(): Called when the activity is no longer visible to the user. This is a good place to release resources that are no longer needed.\n" +
               "\n" +
               "onRestart(): Called when the activity is restarting after being stopped. It's followed by onStart() and onResume() if the activity becomes visible again.\n" +
               "\n" +
               "onDestroy(): Called when the activity is being destroyed. This is where you release any resources that should be cleaned up when the activity is no longer needed."


    }
}