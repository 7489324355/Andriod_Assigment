package com.example.module6application.Que3



import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module6application.R
import com.example.module6application.databinding.ActivityMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.PlacesClient
import java.io.IOException


class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapBinding
    private lateinit var placesClient: PlacesClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Initialize Places API
        Places.initialize(applicationContext, "AIzaSyBoEpsR8aAlVmsBZEhJFhwH7ALqGU7Eqn8")
        placesClient = Places.createClient(this)

        // Set up the button click listener
       binding.showMarkerButton.setOnClickListener {
           val address = binding.addressEditText.text.toString()
           showMarkerOnMap(address)
        }

    }
    override fun onMapReady(googlemap: GoogleMap) {
        mMap = googlemap
    }


    private fun showMarkerOnMap(address: String) {
        // Use Geocoder to get LatLng from the address
        val geocoder = Geocoder(this)

        try {
            val addressList = geocoder.getFromLocationName(address, 1)

            if (addressList!!.isNotEmpty()) {
                val location = LatLng(addressList[0].latitude, addressList[0].longitude)

                mMap.clear()
                mMap.addMarker(MarkerOptions().position(location).title("$address"))
                mMap.moveCamera(CameraUpdateFactory.newLatLng(location))
                mMap.animateCamera(CameraUpdateFactory.zoomTo(15f))
            } else {
                // Handle case where no location is found for the given address
                // You can show a toast or a message to the user
            }
        } catch (e: IOException) {
            e.printStackTrace()
            // Handle Geocoder exceptions, such as IOException
        }
    }

}