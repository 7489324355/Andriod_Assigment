package com.exmple.module4.que_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.exmple.module4.R
import com.exmple.module4.Utils.AppUtils
import com.exmple.module4.databinding.FragmentLoginBinding
import com.google.android.material.textfield.TextInputLayout


class LoginFragment : Fragment() {
    private lateinit var binding:FragmentLoginBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            var email = binding.etEmail.text.toString().trim()

            var password = binding.etPassword1.text.toString().trim()

            resetFocus()
            if (!AppUtils.isvalidemail(email)){
                showerror(binding.inputEmail,"Invalid email address")
            }
            else  if (!AppUtils.isvalidpass(password)){
                showerror(binding.inputPassword,"Invalid password")
            }
            else{
                Toast.makeText(requireContext(),"All Done" , Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSign.setOnClickListener {
            var fragment = RegisterFragment()
            var manager = requireActivity().supportFragmentManager
            var transaction = manager.beginTransaction()
            transaction.replace(R.id.splash,fragment)
            transaction.commit()

        }

    }

    private fun resetFocus() {
        binding.inputEmail.error=null
        binding.inputPassword.error=null
    }

    private fun showerror(inputLayout: TextInputLayout, message:String){
        inputLayout.error=message
        inputLayout.boxStrokeWidth=2
        Toast.makeText(requireContext(), "$message", Toast.LENGTH_SHORT).show()
        inputLayout.requestFocus()

    }


}

