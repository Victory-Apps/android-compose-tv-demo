package com.victoryapps.composetest.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.items
import com.victoryapps.composetest.data.model.Movie
import com.victoryapps.composetest.ui.home.components.GenreRow

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onMovieSelected: (Movie) -> Unit,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    TvLazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        items(viewModel.uiState.value.genres) { genre ->
            GenreRow(
                genre,
                onItemSelected = { onMovieSelected(it) },
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}


@Preview(showBackground = true, device = Devices.TV_1080p)
@Composable
fun HomeScreenPreview() {
    HomeScreen(Modifier, {})
}
