package com.example.movieapp.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.repository.movie_detail.MovieDetailRepository
import com.example.movieapp.utils.collectAndHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val repository: MovieDetailRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _detailState = MutableStateFlow(DetailState())
    val detailState = _detailState.asStateFlow()

    val id: Int = savedStateHandle.get<Int>("id") ?: -1

    init {
        fetchMovieDetailById()
    }

    private fun fetchMovieDetailById() = viewModelScope.launch {
        if (id == -1) {
            _detailState.update {
                it.copy(isLoading = false, error = "Movie not found")
            }
        } else {
            repository.fetchMovieDetail(movieId = id).collectAndHandle(
                onLoading = {
                    _detailState.update {
                        it.copy(isLoading = true, error = null)
                    }
                },
                stateReducer = { movieDetail ->
                    _detailState.update {
                        it.copy(
                            isLoading = false, error = null, movieDetail = movieDetail
                        )
                    }
                },
                onError = { error ->
                    _detailState.update {
                        it.copy(isLoading = false, error = error?.message)
                    }
                }
            )
        }
    }

    fun fetchMovie() = viewModelScope.launch {
        repository.fetchMovie().collectAndHandle(
            onLoading = {
                _detailState.update {
                    it.copy(isMovieLoading = true, error = null)
                }
            },
            stateReducer = { movies ->
                _detailState.update {
                    it.copy(isMovieLoading = false, error = null, movies = movies)
                }
            },
            onError = { error ->
                _detailState.update {
                    it.copy(isMovieLoading = false, error = error?.message)
                }
            }
        )
    }
}