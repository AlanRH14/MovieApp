package com.example.movieapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.repository.movie.MovieRepository
import com.example.movieapp.utils.collectAndHandle
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState = _homeState.asStateFlow()

    private val _effect = MutableSharedFlow<HomeEffect>()
    val effect = _effect.asSharedFlow()

    fun onEvent(event: HomeUIEvent) {

    }

    init {
        fetchDiscoverMovie()
        fetchTrendingMovie()
    }

    private fun fetchDiscoverMovie() = viewModelScope.launch {
        repository.fetchDiscoverMovie().collectAndHandle(
            onLoading = {
                _homeState.update {
                    it.copy(isLoading = true, error = null)
                }
            },
            stateReducer = { movie ->
                _homeState.update {
                    it.copy(isLoading = false, discoverMovies = movie)
                }
            },
            onError = { error ->
                _homeState.update {
                    it.copy(isLoading = false, error = error?.message)
                }
            }
        )
    }

    private fun fetchTrendingMovie() = viewModelScope.launch {
        repository.fetchTrendingMovie().collectAndHandle(
            onLoading = {
                _homeState.update {
                    it.copy(isLoading = true, error = null)
                }
            },
            stateReducer = { movie ->
                _homeState.update {
                    it.copy(isLoading = false, trendingMovies = movie)
                }
            },
            onError = { error ->
                _homeState.update {
                    it.copy(isLoading = false, error = error?.message)
                }
            },
        )
    }
}