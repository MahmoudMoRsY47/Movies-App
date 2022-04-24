package com.example.moviesapp.ui.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.moviesapp.ui.home.repository.MoviesRepository

class MainViewModel : ViewModel() {
    private val repository = MoviesRepository()
    val popularMovies =repository.getPopular().asLiveData()
    val topMovies =repository.getTop().asLiveData()
    val up =repository.getUp().asLiveData()




}