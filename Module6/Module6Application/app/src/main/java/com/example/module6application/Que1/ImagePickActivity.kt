package com.example.module6application.Que1

import android.app.Activity
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.example.module6application.R
import com.example.module6application.databinding.ActivityImagePickBinding
import java.io.File

class ImagePickActivity : AppCompatActivity() {
    private lateinit var binding:ActivityImagePickBinding
    private var imageUri: Uri? = null

    private var cameraContract= registerForActivityResult(ActivityResultContracts.TakePicture()){
         binding.imageView.setImageURI(imageUri)
    }
    private var gellaryContract=registerForActivityResult(ActivityResultContracts.GetContent()){
        binding.imageView.setImageURI(it)
        imageUri=it
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityImagePickBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.btnCamera.setOnClickListener { 
            imageUri=createImageUri()
            cameraContract.launch(imageUri)
            
        }
        binding.btnGallery.setOnClickListener {
//            imageUri=createImageUri()
            gellaryContract.launch("image/*")
        }


    }

    private fun createImageUri(): Uri? {
        var fileName= "${System.currentTimeMillis()}.jpg"
        var imageFile= File(filesDir, fileName)
        return FileProvider.getUriForFile(
            this,
            "com.example.module6application.file_provider",imageFile
        )

    }
}