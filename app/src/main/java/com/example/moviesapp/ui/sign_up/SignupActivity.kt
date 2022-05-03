package com.example.moviesapp.ui.sign_up

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.moviesapp.R
import com.example.moviesapp.databinding.RegisterFragmentBinding
import com.example.moviesapp.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth


class SignupActivity : AppCompatActivity() {
    lateinit var binding: RegisterFragmentBinding
    var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.register_fragment)
        mAuth = FirebaseAuth.getInstance()

        binding.signButton.setOnClickListener {
            signUp()
        }
        binding.Signin.setOnClickListener {
            val intent=Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    private fun signUp(){
        val Email = binding.emailRegister.text.toString()
        val Pass = binding.passwordRegister.text.toString()
        if (Email.isNotEmpty() && Pass.isNotEmpty()) {
            binding.progressBar.visibility=ProgressBar.VISIBLE
            mAuth?.createUserWithEmailAndPassword(Email, Pass)
                ?.addOnCompleteListener {
                    if (it.isSuccessful) {
                        sendEmailVerification()
                        binding.progressBar.visibility=ProgressBar.GONE
                        val intent=Intent(this,LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            applicationContext,
                            it.exception.toString(),
                            Toast.LENGTH_LONG
                        ).show()
                        binding.progressBar.visibility=ProgressBar.GONE
                    }
                }
        } else {
            Toast.makeText(applicationContext,"Please Complete Your information",Toast.LENGTH_LONG).show()
        }
    }

    private fun sendEmailVerification() {
        val user= mAuth?.currentUser
        user?.sendEmailVerification()?.addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(applicationContext, "Email Success Go To Verify Your Email", Toast.LENGTH_LONG)
                    .show()
            }
            else{
                Toast.makeText(applicationContext,"Please Complete Your information",Toast.LENGTH_LONG).show()
            }
        }
    }
}