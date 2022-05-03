package com.example.moviesapp.ui.login


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.moviesapp.MainActivity
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityLoginFragmentBinding
import com.example.moviesapp.ui.sign_up.SignupActivity
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginFragmentBinding
    var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_fragment)
        mAuth = FirebaseAuth.getInstance()
        binding.signup.setOnClickListener {
            val intent= Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        binding.signButton.setOnClickListener {
            logIn()
        }

    }
    private fun logIn(){
        val Email = binding.emailLogin.text.toString()
        val Pass = binding.password.text.toString()
        if (Email.isNotEmpty() && Pass.isNotEmpty()) {
            mAuth?.signInWithEmailAndPassword(Email, Pass)
                ?.addOnCompleteListener {
                    if (it.isSuccessful) {

                        verifyEmail()
                    } else {
                        Toast.makeText(
                            applicationContext,
                            it.exception.toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }
        }else {
            Toast.makeText(applicationContext,"Please Complete Your information",Toast.LENGTH_LONG).show()
        }

    }

    private fun verifyEmail() {
        val user= mAuth?.currentUser
        if (user!!.isEmailVerified ){
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        else{
            Toast.makeText(this,"Please Verify Your Email",Toast.LENGTH_LONG).show()
        }
    }

}