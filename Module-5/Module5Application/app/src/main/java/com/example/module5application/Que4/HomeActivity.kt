package com.example.module5application.Que4

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module5application.Adapter.UserAdapter
import com.example.module5application.Model.Employee
import com.example.module5application.Model.RegisterResponse
import com.example.module5application.Network.ApiEmployee
import com.example.module5application.databinding.ActivityHomeBinding
import com.example.module5application.databinding.BottomsheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    lateinit var mAdapter: UserAdapter
    private var selectedPosition: Int = -1
    private var userList = mutableListOf<Employee>()



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAdapter = UserAdapter(this, userList)
        binding.recyleview.adapter = mAdapter
        binding.recyleview.layoutManager = LinearLayoutManager(this)
        fetchUserData()


        mAdapter.itemDeleteClickListener = { position, user ->
            showAlertDialog(user, position)

        }
        mAdapter.itemUpdateClickListener = { position, user ->
            showBottomSheetDialog(position, user)

        }
        mAdapter.uploadImageClickListener = { position, user ->
            selectedPosition=position
            openImageGallery()
        }


    }

    private fun openImageGallery() {
        // Create an Intent to pick an image from the gallery
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        // Start the gallery activity with a request code
        startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE)
    }

    // Handle the result of the gallery activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            // Get the selected image URI
            val selectedImage: Uri = data.data!!

            // Check if a position is selected
            if (selectedPosition != -1) {
                // Get the user associated with the clicked item using the stored position
                val user = mAdapter.userList[selectedPosition]

                // Convert the selected image URI to a base64-encoded string
                val imageBitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedImage)
                val base64Image = encodeImageToBase64(imageBitmap)

                // Call the uploadProfileImage method with the user and base64-encoded image
                uploadProfileImage(user, base64Image)
            }
        }
    }

    // Function to encode Bitmap image to a base64-encoded string
    private fun encodeImageToBase64(bitmap: Bitmap): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }

    private fun uploadProfileImage(user: Employee, imageUri: String) {
        val filePath = imageUri

        val apiService = ApiEmployee.init()
        val file = File(filePath)
        val requestFile: RequestBody =
            RequestBody.create(MediaType.parse("multipart/form-data"), file)
        val body = MultipartBody.Part.createFormData("image", file.name, requestFile)

        // Assuming that your API endpoint for uploading profile image is properly configured
        apiService.uploadProfileImage(7, user.id, body)
            .enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {
                    if (response.isSuccessful) {
                        val res = response.body()
                        userList[selectedPosition].image = res?.imageUrl.toString()
                        // Notify the adapter that data has changed
                        mAdapter.notifyItemChanged(selectedPosition)
                        // ...
                    } else {
                        // Handle unsuccessful response
                        // ...
                    }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    // Handle failure
                    // ...
                }
            })
    }


    // Function to get the real path from the URI
    private fun getRealPathFromURI(uri: Uri): String {
        val cursor = contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            if (it.moveToFirst()) {
                val idx = it.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
                return it.getString(idx)
            }
        }
        return ""
    }


    private fun showAlertDialog(user: Employee, position: Int) {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Delete")
        builder.setMessage("Are you sure you want to delete this item?")
        builder.setPositiveButton("Delete", DialogInterface.OnClickListener { dialog, which ->
            DeleteUserData(position, user)
        })
        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })
        var dialog = builder.create()
        dialog.show()

    }

    private fun showBottomSheetDialog(position: Int, user: Employee) {
        var bind = BottomsheetDialogBinding.inflate(layoutInflater)
        bind.name.setText(user.name)
        bind.email.setText(user.email)
        bind.mobile.setText(user.contact)
        var dialog = BottomSheetDialog(this)
        dialog.setContentView(bind.root)
        dialog.show()

        bind.update.setOnClickListener {
            user.name = bind.name.text.toString()
            user.contact = bind.mobile.text.toString()

            UpdateUserData(position, user)
            intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)

        }
        bind.cancel.setOnClickListener {
            dialog.dismiss()
        }

    }

    private fun fetchUserData() {
        ApiEmployee.init().getUsers(flag = 4).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>, response: Response<RegisterResponse>
            ) {

                if (response.isSuccessful) {
                    val users = response.body()?.user
                    users?.let {
                        mAdapter.userList = it
                        mAdapter.notifyDataSetChanged()
                    }

                }

            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message} ")
            }

        })

    }

    private fun UpdateUserData(position: Int, user: Employee) {
        ApiEmployee.init().updateUser(2, user.id, user.name, user.contact).enqueue(object :
            Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>, response: Response<RegisterResponse>
            ) {

                if (response.isSuccessful) {
                    var res = response.body()

                    if (res?.status == "success") {
                        if (position >= 0 && position < userList.size) {
                            userList[position] = user
                            mAdapter.updateList(userList)


                        }
                    }

                }

            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message} ")
            }

        })

    }

    private fun DeleteUserData(position: Int, user: Employee) {
        ApiEmployee.init().deleteUser(3, user.id).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>, response: Response<RegisterResponse>
            ) {

                if (response.isSuccessful) {
                    var res = response.body()
                    if (res?.status == "success") {

                        mAdapter.deleteItem(position)

                    }

                }

            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message} ")
            }

        })

    }
    companion object {
        private const val GALLERY_REQUEST_CODE = 1
    }

}


