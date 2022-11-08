package com.example.brochill.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.brochill.SharedPreference
import com.example.brochill.databinding.ActivitySignUpBinding
import com.example.brochill.viewmodel.HomeViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: HomeViewModel
    private var email:String=""
    private lateinit var sharedPreferences: SharedPreference
    private var emailAuth="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
   var pattern = Pattern.compile(emailAuth);
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
            var email1=pattern.matcher(email)


            if(firstName.isNotEmpty()&&lastName.isNotEmpty()&&email.isNotEmpty()&&password.isNotEmpty()){
                if(validateEmail(email)) {
                    binding.progress.visibility = View.VISIBLE
                    viewModel.register(firstName, lastName, email, password)
                }else{
                    Toast.makeText(this,"Enter a valid email address",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Fill the empty blocks",Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.userRegistered.observe(this){
            binding.progress.visibility=View.INVISIBLE
            Toast.makeText(this,"User Registered Already",Toast.LENGTH_SHORT).show()
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
    fun validateEmail(email: String?): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val EMAIL_PATTERN =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        pattern = Pattern.compile(EMAIL_PATTERN)
        matcher = pattern.matcher(email)
        return matcher.matches()
    }


}