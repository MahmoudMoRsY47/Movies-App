package com.example.moviesapp.ui.movie_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityDetailsOfMovieBinding
import com.example.moviesapp.model.Result
import com.example.moviesapp.ui.home.ui.MainViewModel
import com.hamdy.showtime.ui.model.MoviesDetailsResponse

class DetailsOfMovie : AppCompatActivity() {
    lateinit var binding : ActivityDetailsOfMovieBinding
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_details_of_movie)
        binding.lifecycleOwner=this

        val moviesDe : Result?=intent.getSerializableExtra("id")as Result?
        moviesDe?.let{bindmovie(it)}

    }

   fun bindmovie(it: Result) {
        binding.apply {
            name.text=it.originalTitle
            overView.text=it.overview
           Date.text=it.originCountry
            val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
            val moviePosterURL = POSTER_BASE_URL + it.posterPath
            Glide.with(imagee)
                .load(moviePosterURL)
                .into(imagee);
        }

    }
}