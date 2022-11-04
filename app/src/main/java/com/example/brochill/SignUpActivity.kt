package com.example.brochill

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brochill.databinding.ActivityLoginBinding
import com.example.brochill.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signUp.setOnClickListener{

            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}