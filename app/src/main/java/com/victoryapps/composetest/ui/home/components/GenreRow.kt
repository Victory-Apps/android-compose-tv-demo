package com.victoryapps.composetest.ui.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.foundation.lazy.list.items
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.victoryapps.composetest.data.model.Genre
import com.victoryapps.composetest.data.model.Movie

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun GenreRow(
    genre: Genre,
    modifier: Modifier = Modifier,
    onItemSelected: (Movie) -> Unit = {},
) {
    Text(
        text = genre.title,
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    )
    TvLazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(genre.movies) { movie ->
            MovieCard(
                movie = movie,
                onClick = { onItemSelected(movie) }
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.TV_1080p)
@Composable
fun GenreRowPreview() {
    GenreRow(Genre(1, "Action", emptyList()))
}
