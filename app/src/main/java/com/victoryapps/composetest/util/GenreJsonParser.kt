package com.victoryapps.composetest.util

import android.content.Context
import com.victoryapps.composetest.data.model.Genre
import com.victoryapps.composetest.data.model.MoviesResponse
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

class GenreJsonParser(
    private val context: Context
) {
    @OptIn(ExperimentalSerializationApi::class)
    fun readMoviesFromAssets(): List<Genre> =
        try {
            context.assets.open(genresFile).use {
                Json.decodeFromStream<MoviesResponse>(it).genres
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }

    companion object {
        const val genresFile = "genres.json"
    }
}
