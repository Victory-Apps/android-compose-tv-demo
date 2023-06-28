package com.victoryapps.composetest.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import com.victoryapps.composetest.data.Genre
import com.victoryapps.composetest.data.Movie
import com.victoryapps.composetest.theme.ComposeTestTheme

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun DetailsScreen(
    genres: List<Genre>,
    modifier: Modifier = Modifier,
    onItemSelected: (Movie) -> Unit = {},
) {
    ComposeTestTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
        ) {

        }
    }
}

//@Preview(showBackground = true, device = Devices.TV_1080p)
//@Composable
//fun DetailsScreenPreview() {
//    val genres = listOf(Genre())
//    DetailsScreen(listOf(
//
//    ))
//}
