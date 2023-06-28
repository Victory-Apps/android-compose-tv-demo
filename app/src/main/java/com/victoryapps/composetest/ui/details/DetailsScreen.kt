package com.victoryapps.composetest.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.Button
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.victoryapps.composetest.data.Movie
import com.victoryapps.composetest.extension.getDrawableIdByName
import com.victoryapps.composetest.theme.ComposeTestTheme

object DetailsScreenArgs {
    const val movieId = "movieId"
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun DetailsScreen(
    movieId: Int,
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    onItemSelected: (Movie) -> Unit = {},
) {
    val viewModel: DetailsScreenViewModel = hiltViewModel()
    viewModel.retrieveMovie(movieId)

}

@Preview(showBackground = true, device = Devices.TV_1080p)
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(1)
}
