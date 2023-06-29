package com.victoryapps.composetest.data

import com.victoryapps.composetest.data.model.Genre
import com.victoryapps.composetest.data.model.GenreTypes
import com.victoryapps.composetest.data.model.Movie
import com.victoryapps.composetest.util.GenreJsonParser
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Inject

interface MovieRepository {
    suspend fun retrieveGenres(): List<Genre>
    suspend fun retrieveMovie(id: Int): Movie?
}

@OptIn(ExperimentalSerializationApi::class)
class MovieRepositoryImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val genreJsonParser: GenreJsonParser
) :
    MovieRepository {

    override suspend fun retrieveGenres(): List<Genre> = withContext(dispatcher) {
        genreJsonParser.readMoviesFromAssets().map {
            it.movies = it.movies.map { movie ->
                movie.thumbnail = GenreTypes.fromId(it.id).drawable
                movie
            }
            it
        }
    }

    override suspend fun retrieveMovie(id: Int): Movie? = withContext(dispatcher) {
        genreJsonParser.readMoviesFromAssets().flatMap {
            it.movies = it.movies.map { movie ->
                movie.thumbnail = GenreTypes.fromId(it.id).drawable
                movie
            }
            it.movies
        }.firstOrNull { it.id == id }
    }
}