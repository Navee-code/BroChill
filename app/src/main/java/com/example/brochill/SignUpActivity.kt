package com.example.brochill

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.brochill.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding.signUp.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
        binding.signUp.setOnClickListener {
            var firstName=binding.firstName.text.toString().trim()
            var lastName=binding.lastName.text.toString().trim()
            var email=binding.email.text.toString().trim()
            var password=binding.password.toString().trim()
            viewModel.register(firstName,lastName,email,password)
        }
    }
}