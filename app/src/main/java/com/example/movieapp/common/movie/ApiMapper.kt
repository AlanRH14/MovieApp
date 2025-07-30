package com.example.movieapp.common.movie

interface ApiMapper<ApiDto, Domain> {
    fun mapToDomain(apiDto: ApiDto): Domain
}