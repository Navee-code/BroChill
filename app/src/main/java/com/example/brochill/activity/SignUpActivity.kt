package com.example.brochill.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.brochill.HomeViewModel
import com.example.brochill.SharedPreference
import com.example.brochill.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: HomeViewModel
    private var email:String=""
    private lateinit var sharedPreferences: SharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences= SharedPreference()
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding.signUp.setOnClickListener {
            var firstName=binding.firstName.text.toString().trim()
            var lastName=binding.lastName.text.toString().trim()
            email=binding.email.text.toString().trim()
            var password=binding.password.text.toString().trim()
            if(firstName.isNotEmpty()&&lastName.isNotEmpty()&&email.isNotEmpty()&&password.isNotEmpty()){
                binding.progress.visibility=View.VISIBLE
                viewModel.register(firstName,lastName,email,password)
            }else{
                Toast.makeText(this,"Fill the empty blocks",Toast.LENGTH_SHORT).show()
            }
        }


        viewModel.registerCredential.observe(this){
            if(email ==it.email){
                sharedPreferences.setToken(it.token,this)
                binding.progress.visibility=View.INVISIBLE
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
    override fun onBackPressed() {
        startActivity(Intent(applicationContext, LoginActivity::class.java))
        super.onBackPressed()

    }


}