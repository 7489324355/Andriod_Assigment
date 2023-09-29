package com.exmple.module3application.que_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exmple.module3application.R
import com.exmple.module3application.databinding.ActivityJavaFileBinding

class JavaFileActivity : AppCompatActivity() {
    private lateinit var binding:ActivityJavaFileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityJavaFileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvName.text="Android R. java is an auto-generated file by aapt (Android Asset Packaging Tool) that contains resource IDs for all the resources of res/ directory. If you create any component in the activity_main. xml file, id for the corresponding component is automatically created in this file."
    }
}