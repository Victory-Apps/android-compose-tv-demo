package com.victoryapps.composetest.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.items
import androidx.tv.foundation.lazy.list.rememberTvLazyListState
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import com.victoryapps.composetest.theme.ComposeTestTheme
import com.victoryapps.composetest.ui.home.view.GenreRow

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier, viewModel: HomeScreenViewModel) {

    ComposeTestTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            TvLazyColumn(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(24.dp),
            ) {
                items(viewModel.uiState.value.genres) { genre ->
                    GenreRow(genre, onItemSelected = {  }, modifier = Modifier.padding(bottom = 16.dp))
                }
            }
        }
    }
}


//@Preview(showBackground = true, device = Devices.TV_1080p)
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen()
//}
