package com.exmple.module4.que_10


import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.exmple.module4.databinding.ActivityPdfBinding



class PdfActivity : AppCompatActivity() {

    private lateinit var binding:ActivityPdfBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPdfBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.openPdfButton.setOnClickListener {
            openPdf()

        }
    }


    private fun openPdf() {
        val pdfFileUri = Uri.parse("https://www.africau.edu/images/default/sample.pdf")

        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(pdfFileUri, "application/pdf")
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Log.e("PdfActivity", "Error opening PDF: ${e.message}")
            // Show a toast message indicating the issue
            Toast.makeText(this, "No PDF viewer app installed or error opening PDF.", Toast.LENGTH_SHORT).show()
        }
    }
}