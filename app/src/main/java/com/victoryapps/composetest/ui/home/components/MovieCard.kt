package com.victoryapps.composetest.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Card
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.victoryapps.composetest.data.model.GenreTypes
import com.victoryapps.composetest.data.model.Movie
import com.victoryapps.composetest.extension.getDrawableIdByName

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun MovieCard(
    movie: Movie,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .defaultMinSize(minHeight = 100.dp)
            .aspectRatio(ratio = 5f / 3f),
        onClick = onClick
    ) {
        Box(Modifier.fillMaxSize()) {
            val drawableId = LocalContext.current.getDrawableIdByName(movie.thumbnail)
            Image(
                painter = painterResource(drawableId),
                contentDescription = movie.title,
                modifier = Modifier
                    .fillMaxSize()
                    .blur(8.dp),
                contentScale = ContentScale.Crop
            )

            val brush = Brush.verticalGradient(listOf(Color.Transparent, Color.Black), 0.75f)
            Text(
                text = movie.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(brush)
                    .padding(4.dp),
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.TV_1080p)
@Composable
fun MovieCardPreview() {
    MovieCard(
        Movie(
            1,
            "Movie Title",
            "Movie description",
            Movie.Companion.url,

            GenreTypes.Action.drawable,
            "2 hours",
            8.5f
        )
    )
}
