package com.victoryapps.composetest.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(val genres: List<Genre>)