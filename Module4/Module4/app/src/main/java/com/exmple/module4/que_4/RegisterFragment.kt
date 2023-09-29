package com.exmple.module4.que_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import com.exmple.module4.R
import com.exmple.module4.Utils.AppUtils
import com.exmple.module4.databinding.FragmentRegisterBinding
import com.google.android.material.textfield.TextInputLayout


class RegisterFragment : Fragment() {
    private lateinit var binding:FragmentRegisterBinding
    private var GradutionArray = arrayOf("Select Graduation!","BCA", "BCOM", "BA", "BSC", "BBA")
    private lateinit var graAdpater: ArrayAdapter<String>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSign.setOnClickListener {
            var email = binding.etEmail.text.toString().trim()
            var contact = binding.etContact.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()
            var cpassword = binding.etCpass.text.toString().trim()
            var name = binding.etName.text.toString().trim()

            resetFocus()

            if (!AppUtils.isvalidname(name)) {
                showerror(binding.inputName, "Should be alphbets only")
            } else if (!AppUtils.isvalidemail(email)) {
                showerror(binding.inputEmail, "Invalid email address")
            } else if (!AppUtils.isvalidcontact(contact)) {
                showerror(binding.inputContact, "Invalid Contact")
            } else if (!AppUtils.isvalidpass(password)) {
                showerror(binding.inputPassword, "invalid Password")
            } else if (cpassword != password) {
                showerror(binding.inputCpass, "Mismatch Passwprd")
            }
            else if (!validation()){
                Toast.makeText(requireContext(), " please select your Graducation", Toast.LENGTH_SHORT).show()

            }
            else if (!check()) {
                Toast.makeText(requireContext(), " please select gender", Toast.LENGTH_SHORT).show()

            }
            else {
                var fragment = LoginFragment()

                var manager = requireActivity().supportFragmentManager
                var transaction = manager.beginTransaction()
                transaction.replace(R.id.splash, fragment)
                transaction.commit()

            }

        }

        graAdpater = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            GradutionArray
        )
        binding.degree.adapter = graAdpater



        binding.degree.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }

    private fun resetFocus() {
        binding.inputEmail.error = null
        binding.inputPassword.error = null
        binding.inputContact.error = null
        binding.inputCpass.error = null
        binding.inputName.error = null
        binding.linear.setBackgroundResource(R.drawable.et_white_bg)
    }

    private fun showerror(inputLayout: TextInputLayout, message: String) {
        inputLayout.error = message
        inputLayout.boxStrokeWidth = 2
        Toast.makeText(requireContext(), "$message", Toast.LENGTH_SHORT).show()
        inputLayout.requestFocus()
    }

    private fun check(): Boolean {
        var male = binding.radiogroup.checkedRadioButtonId
        if (male == -1) {
            return false

        } else {
            val selectedRadioButton = requireView().findViewById<RadioButton>(male)
            val selectedGender = selectedRadioButton.text.toString()
            Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT)
                .show()
            return true

        }


    }

    private fun validation():Boolean{
        var selectposition = binding.degree.selectedItemPosition
//
        if (selectposition <= 0 ) {

//           Toast.makeText(requireContext(), "select your Graduation", Toast.LENGTH_SHORT).show()
            binding.linear.setBackgroundResource(R.drawable.bg_sppinner)
            return false


        } else {
//           Toast.makeText(requireContext(), "select your Graduation", Toast.LENGTH_SHORT).show()
//           binding.linear.setBackgroundResource(R.drawable.bg_sppinner)

            return true
        }
    }


}