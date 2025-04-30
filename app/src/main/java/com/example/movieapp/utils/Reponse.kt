package com.example.movieapp.utils

sealed class Response<T>{
    class Success<T>(val data:T): Response<T>()
    class Error<T>(val error:Throwable?,val data:T? = null): Response<T>()
    class Loading<T>: Response<T>()
}