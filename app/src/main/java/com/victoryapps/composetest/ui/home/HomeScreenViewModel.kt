package com.victoryapps.composetest.ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.victoryapps.composetest.data.Genre
import com.victoryapps.composetest.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeScreeUIState(val loading: Boolean, val genres: List<Genre>)

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {

    init {
        retrieveGenres()
    }

    private val _uiState = mutableStateOf(HomeScreeUIState(true, listOf()))
    val uiState: State<HomeScreeUIState>
        get() = _uiState

    private fun retrieveGenres() {
        viewModelScope.launch {
            val genres = movieRepository.retrieveGenres()
            _uiState.value = HomeScreeUIState(false, genres)
        }
    }
}