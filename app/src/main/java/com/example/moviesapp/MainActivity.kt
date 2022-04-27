package com.example.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.ui.actors.ui.ActorsFragment
import com.example.moviesapp.ui.home.ui.HomeFragment
import com.example.moviesapp.ui.home.ui.MainViewModel
import com.example.moviesapp.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()
    lateinit var binding : ActivityMainBinding
    val fragmentHome= HomeFragment()
    val fragmentProfile=ProfileFragment()
    val fragmentActors= ActorsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)


        initView()
        addNavigationListner()

    }

    private fun initView() {
        val transiction= supportFragmentManager.beginTransaction()
        transiction.replace(R.id.fragment_container,fragmentHome)
        transiction.commit()
    }

    private fun addNavigationListner() {
        binding.nav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.HomePage -> {
                    showFragment(fragmentHome)
                    true
                }
                R.id.Profile -> {
                    showFragment(fragmentProfile)
                    true
                }
                R.id.Actors -> {
                    showFragment(fragmentActors)
                    true
                }
                else ->false
            }
        }
    }


    private fun showFragment(fragment : Fragment) {
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
    }


}