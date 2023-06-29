package com.victoryapps.composetest.ui.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.victoryapps.composetest.data.MovieRepository
import com.victoryapps.composetest.data.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class DetailsScreeUIState(val movie: Movie?)

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {

    private val _uiState = mutableStateOf(DetailsScreeUIState(null))
    val uiState: State<DetailsScreeUIState>
        get() = _uiState

    suspend fun retrieveMovie(id: Int) {
        val movie = movieRepository.retrieveMovie(id)
        _uiState.value = DetailsScreeUIState(movie)
    }
}