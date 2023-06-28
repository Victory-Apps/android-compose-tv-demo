package com.victoryapps.composetest.util

import android.content.Context
import com.victoryapps.composetest.data.Genre
import com.victoryapps.composetest.data.MoviesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

class GenreJsonParser(private val context: Context) {

    @ExperimentalSerializationApi
    suspend fun readMoviesFromAssets(): List<Genre> =
        withContext(Dispatchers.IO) {
            try {
                context.assets.open(genresFile).use {
                    Json.decodeFromStream<MoviesResponse>(it).genres
                }
            } catch (e: Exception) {
                e.printStackTrace()
                emptyList()
            }
        }

    companion object {
        const val genresFile = "genres.json"
    }
}
