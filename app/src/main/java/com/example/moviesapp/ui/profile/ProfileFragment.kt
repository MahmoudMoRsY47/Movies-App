package com.example.moviesapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ProfileFragmentBinding
import com.example.moviesapp.ui.home.ui.HomeViewModel

class ProfileFragment :Fragment() {
    private val viewModel : HomeViewModel by viewModels()
    lateinit var binding : ProfileFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.profile_fragment, container, false)
        return binding.root
    }
}