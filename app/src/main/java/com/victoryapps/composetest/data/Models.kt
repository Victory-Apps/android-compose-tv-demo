package com.victoryapps.composetest.data

import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(val genres: List<Genre>)

@Serializable
data class Genre(
    val id: Int,
    val title: String,
    var movies: List<Movie>
)

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    var thumbnail: String = GenreEnum.Action.drawable,
    val media: String = url,
    val duration: String,
    val rating: Float
) {
    companion object {
        const val url = "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8"
    }
}

enum class GenreEnum(val id: Int, val drawable: String) {
    Action(1, "action_thumbnail"),
    Comedy(2, "comedy_thumbnail"),
    Drama(3, "drama_thumbnail"),
    SciFi(4, "scifi_thumbnail");

    companion object {
        fun fromId(id: Int) = GenreEnum.values().firstOrNull { it.id == id } ?: Action
    }
}