package com.example.registrationfirebasefragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.registrationfirebasefragments.databinding.FragmentLoggedOutBinding


class loggedOut : Fragment() {
    private lateinit var binding:FragmentLoggedOutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoggedOutBinding.inflate(inflater, container, false)
        setListenerOnLogin()
        setListenerOnRegister()
        return binding.root
    }
    fun setListenerOnLogin(){
        binding.login.setOnClickListener{
            findNavController().navigate(R.id.action_loggedOut_to_login)
        }
    }
    fun setListenerOnRegister(){
        binding.register.setOnClickListener {
            findNavController().navigate(R.id.action_loggedOut_to_register1)
        }
    }

}