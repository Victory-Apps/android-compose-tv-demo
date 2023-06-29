package com.victoryapps.composetest.ui.details

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.tv.material3.Button
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.victoryapps.composetest.R
import com.victoryapps.composetest.data.model.Movie
import com.victoryapps.composetest.extension.getDrawableIdByName

object DetailsScreenArgs {
    const val movieId = "movieId"
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun DetailsScreen(
    movieId: Int,
    modifier: Modifier = Modifier,
    onMovieSelected: (Movie) -> Unit,
    viewModel: DetailsScreenViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.retrieveMovie(movieId)
    }

    AnimatedVisibility(
        visible = viewModel.uiState.value.movie != null,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        viewModel.uiState.value.movie?.let { movie ->
            Box(modifier = modifier.fillMaxSize()) {
                val drawableId = LocalContext.current.getDrawableIdByName(movie.thumbnail)
                val brush = Brush.horizontalGradient(listOf(Color.Black, Color.Transparent))
                Image(
                    painter = painterResource(drawableId),
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = movie.title,
                    contentScale = ContentScale.Crop,
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(brush)
                        .padding(32.dp)
                ) {
                    Text(
                        text = movie.title,
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Text(
                        text = movie.description,
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth(0.75f),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    Text(
                        modifier = Modifier.padding(top = 24.dp),
                        text = context.getString(R.string.duration, movie.duration),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = context.getString(R.string.rating, movie.rating),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Button(
                        modifier = Modifier.padding(top = 24.dp),
                        onClick = { onMovieSelected(movie) }) {
                        Text(text = LocalContext.current.getString(R.string.play_movie))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.TV_1080p)
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(1, Modifier, {})
}
