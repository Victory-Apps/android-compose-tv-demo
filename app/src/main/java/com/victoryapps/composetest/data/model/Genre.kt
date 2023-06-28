package com.victoryapps.composetest.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    val id: Int,
    val title: String,
    var movies: List<Movie>
)


