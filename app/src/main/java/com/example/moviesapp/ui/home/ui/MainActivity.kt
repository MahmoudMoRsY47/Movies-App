package com.example.moviesapp.ui.home.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.model.Result
import com.example.moviesapp.ui.home.adapter.MovieAdapter
import com.example.moviesapp.ui.home.adapter.MoviesDetailsInter
import com.example.moviesapp.ui.movie_details.DetailsOfMovie

class MainActivity : AppCompatActivity(),MoviesDetailsInter {

    private val viewModel : MainViewModel by viewModels()
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)
        binding.lifecycleOwner=this
        binding.view=viewModel

         val adapter = MovieAdapter(mutableListOf(),this)
        binding.rcv.adapter=adapter

        val adapter1 = MovieAdapter(mutableListOf(),this)
        binding.rcv1.adapter=adapter1

        val adapter2 = MovieAdapter(mutableListOf(),this)
        binding.rcv2.adapter=adapter2

    }

    override fun onClickItem(movies: Result) {
        val Myintent =Intent(this,DetailsOfMovie::class.java)
        Myintent.putExtra("id",movies)
        startActivity(Myintent)
    }


}