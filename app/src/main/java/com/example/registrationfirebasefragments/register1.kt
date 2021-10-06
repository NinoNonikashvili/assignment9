package com.example.registrationfirebasefragments

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.registrationfirebasefragments.databinding.FragmentRegister1Binding
import com.google.firebase.auth.FirebaseAuth


class register1 : Fragment() {
    private lateinit var binding: FragmentRegister1Binding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentRegister1Binding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()
        setListenerOnArrow()
        setListenerOnNext()
        return binding.root
    }
    fun setListenerOnNext(){

        binding.next.setOnClickListener {
            checkInput()

        }
    }
    fun setListenerOnArrow(){
        binding.arrowBack.setOnClickListener{
            findNavController().navigate(R.id.action_register1_to_loggedOut)
        }
    }
    fun checkInput(){
        if (binding.email.text.toString().isEmpty()) {
            binding.email.error = "please write the email"
            binding.email.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(binding.email.text.toString()).matches()) {
            binding.email.error = "please write valid email"
            binding.email.requestFocus()
            return
        }
        if (binding.password.text.toString().isEmpty()) {
            binding.password.error = "please write the password"
        }
        var emailAndPassword = "${binding.email.text.toString()} ${binding.password.text.toString()}"
        var bundle = bundleOf("email" to emailAndPassword)
        findNavController().navigate(R.id.action_register1_to_register2, bundle)
    }

}