package com.example.registrationfirebasefragments

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.registrationfirebasefragments.databinding.FragmentRegister2Binding
import com.google.firebase.auth.FirebaseAuth

class register2 : Fragment() {
    private lateinit var binding:FragmentRegister2Binding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegister2Binding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()

        setWarningText()
        setListeneronSignUp()

        return binding.root
    }
    fun setWarningText(){
        val text  = "By signing up, you agree to Photo’s "+getString(R.string.terms) +" and "+getString(R.string.policies)+"."

        binding.warningtext.text =text
    }
    fun setListeneronSignUp(){
        binding.signUp.setOnClickListener{
            addUser()
            findNavController().navigate(R.id.action_register2_to_loggedOut)
        }

    }
    fun addUser() {
        val myString = arguments?.getString("email")
        val parts = myString?.split(" ")
        val email = parts!!.get(0)
        val password = parts!!.get(1)
        Log.d("show", "$email, $password")

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)

                }
            }
    }


}