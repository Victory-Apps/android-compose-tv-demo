package com.victoryapps.composetest.data

import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(val genres: List<Genre>)

@Serializable
data class Genre(
    val id: Int,
    val title: String,
    val movies: List<Movie>
)

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val heroUrl: String? = null,
    val thumbnailUrl: String? = null,
    val duration: String,
    val rating: Float
)