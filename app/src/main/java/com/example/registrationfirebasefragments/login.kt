package com.example.registrationfirebasefragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.registrationfirebasefragments.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth


class login : Fragment() {
    private lateinit var binding:FragmentLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()

        setListenerOnArrow()
        setListenerOnNext()
        binding.loginBtn.setOnClickListener{ login() }
        return binding.root
    }
    fun setListenerOnArrow(){
        binding.arrowBack.setOnClickListener{
            findNavController().navigate(R.id.action_login_to_loggedOut)
        }
    }
    fun setListenerOnNext(){
        binding.loginBtn.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_loggedOut)
        }
    }
    fun login(){
        if(binding.email.text.toString().isEmpty()){
            binding.email.error = "please write the email"
            binding.email.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(binding.email.text.toString()).matches()){
            binding.email.error="please write valid email"
            binding.email.requestFocus()
            return
        }
        if(binding.password.text.toString().isEmpty()){
            binding.password.error = "please write the password"
        }
        auth.signInWithEmailAndPassword(binding.email.text.toString(), binding.password.text.toString())
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                }
            }

    }

}



