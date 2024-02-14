package com.example.module7application.Que6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import com.example.module7application.R
import com.example.module7application.databinding.ActivitySpeechBinding
import java.util.Locale

class SpeechActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySpeechBinding
    private lateinit var textToSpeech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySpeechBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textToSpeech= TextToSpeech(this){
            if (it === TextToSpeech.SUCCESS){
                var result = textToSpeech.setLanguage(Locale.US)
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){

                }
            }
        }
        binding.convertButton.setOnClickListener {
            val textToConvert = binding.editText.text.toString()
            if (textToConvert.isNotEmpty()) {
                textToSpeech.speak(textToConvert, TextToSpeech.QUEUE_FLUSH, null, null)
            }
        }


    }
    override fun onDestroy() {
        // Shutdown the TextToSpeech engine when the activity is destroyed
        if (::textToSpeech.isInitialized) {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
        super.onDestroy()
    }
}