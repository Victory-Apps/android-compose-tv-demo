package com.victoryapps.composetest.data

import com.victoryapps.composetest.data.model.Genre
import com.victoryapps.composetest.data.model.GenreTypes
import com.victoryapps.composetest.data.model.Movie
import com.victoryapps.composetest.util.GenreJsonParser
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Inject

interface MovieRepository {
    suspend fun retrieveGenres(): List<Genre>
    suspend fun retrieveMovie(id: Int): Movie?
}

@OptIn(ExperimentalSerializationApi::class)
class MovieRepositoryImpl @Inject constructor(private val genreJsonParser: GenreJsonParser) :
    MovieRepository {

    override suspend fun retrieveGenres(): List<Genre> =
        genreJsonParser.readMoviesFromAssets().map {
            it.movies = it.movies.map { movie ->
                movie.thumbnail = GenreTypes.fromId(it.id).drawable
                movie
            }
            it
        }

    override suspend fun retrieveMovie(id: Int): Movie? =
        genreJsonParser.readMoviesFromAssets().flatMap {
            it.movies = it.movies.map { movie ->
                movie.thumbnail = GenreTypes.fromId(it.id).drawable
                movie
            }
            it.movies
        }.firstOrNull { it.id == id }
}