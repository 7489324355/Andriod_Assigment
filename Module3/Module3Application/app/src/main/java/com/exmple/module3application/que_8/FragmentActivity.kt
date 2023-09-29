package com.exmple.module3application.que_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exmple.module3application.R
import com.exmple.module3application.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvActivity.text="In Android app development, a \"fragment\" is a modular and reusable portion of a user interface (UI) that can be combined with other fragments to create a complete user interface for an activity. Fragments are designed to represent a portion of a user interface with its own layout, behavior, and lifecycle. They are particularly useful for creating flexible and responsive UIs, especially for larger screens and tablets.\n" +
                "\n" +
                "Fragments have their own lifecycle, which is similar to the lifecycle of an activity but with some differences. The fragment lifecycle consists of various callback methods that allow you to manage the fragment's behavior and state throughout its lifecycle."

        binding.tvLifecycle.text="onAttach(): Called when the fragment is attached to an activity. It provides a reference to the hosting activity and is a good place to perform initialization that requires access to the activity.\n" +
                "\n" +
                "onCreate(): Similar to the onCreate() method in activities, this is called when the fragment is created. It is where you typically initialize the fragment's resources and perform any one-time setup.\n" +
                "\n" +
                "onCreateView(): This method is responsible for creating and returning the fragment's UI, which is a View object. It is where you inflate the fragment's layout XML file and set up the UI components.\n" +
                "\n" +
                "onActivityCreated(): Called when the hosting activity's onCreate() method has completed. It's a good place to interact with the activity and its views.\n" +
                "\n" +
                "onStart(): Called when the fragment becomes visible to the user but is not yet interactive. It's similar to the onStart() method in activities.\n" +
                "\n" +
                "onResume(): Called when the fragment is visible and ready to interact with the user, similar to the onResume() method in activities.\n" +
                "\n" +
                "onPause(): Called when the fragment is no longer actively interacting with the user. This is where you should pause ongoing operations or release resources that are no longer needed.\n" +
                "\n" +
                "onStop(): Called when the fragment is no longer visible. It's similar to the onStop() method in activities.\n" +
                "\n" +
                "onDestroyView(): Called when the fragment's UI is being destroyed. You should release references to UI elements and resources in this method.\n" +
                "\n" +
                "onDestroy(): Similar to the onDestroy() method in activities, this is called when the fragment is being destroyed. You should release any remaining resources here.\n" +
                "\n" +
                "onDetach(): Called when the fragment is detached from the hosting activity. It's a good place to clean up any references to the activity."
    }
}