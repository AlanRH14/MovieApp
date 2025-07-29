package com.example.movieapp.presentation.detail.mvi

sealed interface DetailEffect {
    data object NavigateToBack: DetailEffect
    data class NavigateToDetail(val movieID: Int): DetailEffect
}