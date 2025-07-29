package com.example.movieapp.di

import com.example.movieapp.presentation.detail.MovieDetailViewModel
import com.example.movieapp.presentation.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(repository = get()) }
    viewModel { MovieDetailViewModel(repository = get()) }
}