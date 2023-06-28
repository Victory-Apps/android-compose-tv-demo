package com.victoryapps.composetest.ui.video

import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.victoryapps.composetest.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VideoScreenViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
}