package com.example.movieapp.presentation.detail.mvi

sealed interface DetailUIEvent {
    data class OnFetchDetailById(val movieID: Int) : DetailUIEvent
    data object OnFetch : DetailUIEvent
    data class OnClicked(val movieID: Int) : DetailUIEvent
    data class OnActorClicked(val actorID: Int): DetailUIEvent
    data object OnNavigateToBack : DetailUIEvent
}