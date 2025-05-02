package com.example.movieapp.common.movie

interface ApiMapper<Domain, Entity> {
    fun mapToDomain(apiDto: Entity): Domain
}