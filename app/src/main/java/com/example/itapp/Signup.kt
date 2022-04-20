package com.example.itapp

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.itapp.databinding.ActivitySignupBinding
import com.example.itapp.ui.login.LoginViewModel
import com.example.itapp.ui.login.afterTextChanged
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class Signup : AppCompatActivity() {

    private lateinit var binding:ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            val intent = Intent(this, Signin::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {

            val email = binding.emailEt.text.toString()
            val password = binding.passET.text.toString()
            val confrimPassword = binding.confirmPassEt.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confrimPassword.isNotEmpty()){
                if (password == confrimPassword){
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful){
                            val intent = Intent(this, Signin::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else{
                    binding.confirmPasswordLayout.error = "Password don't Match"
                }
            } else {
                binding.passwordLayout.error = "*Required"
                binding.confirmPasswordLayout.error = "*Required"
                binding.emailLayout.error = "*Required"
            }
        }
    }
}