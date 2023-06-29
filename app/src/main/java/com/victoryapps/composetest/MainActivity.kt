package com.victoryapps.composetest

import VideoPlayerScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices.TV_1080p
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import com.victoryapps.composetest.theme.ComposeTestTheme
import com.victoryapps.composetest.ui.details.DetailsScreen
import com.victoryapps.composetest.ui.details.DetailsScreenArgs
import com.victoryapps.composetest.ui.home.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun App() {
    ComposeTestTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Screens.Home()) {
                composable(
                    route = Screens.Home(),
                    enterTransition = { fadeIn() },
                    exitTransition = { fadeOut() }
                ) {
                    HomeScreen(onMovieSelected = {
                        navController.navigate(
                            Screens.Details.withArgs(
                                it.id
                            )
                        )
                    })
                }
                composable(
                    route = Screens.Details(),
                    arguments = listOf(navArgument(DetailsScreenArgs.movieId) {
                        type = NavType.IntType
                    }),
                    enterTransition = { fadeIn() },
                    exitTransition = { fadeOut() }
                ) { backStackEntry ->
                    val movieId = backStackEntry.arguments?.getInt(DetailsScreenArgs.movieId) ?: 1
                    DetailsScreen(
                        movieId = movieId,
                        onMovieSelected = { navController.navigate(Screens.VideoPlayer.withArgs(it.id)) })
                }
                composable(
                    route = Screens.VideoPlayer(),
                    arguments = listOf(navArgument(DetailsScreenArgs.movieId) {
                        type = NavType.IntType
                    }),
                    enterTransition = { fadeIn() },
                    exitTransition = { fadeOut() }
                ) { backStackEntry ->
                    val movieId = backStackEntry.arguments?.getInt(DetailsScreenArgs.movieId) ?: 1
                    VideoPlayerScreen(movieId)
                }
            }
        }
    }
}

@Preview(showBackground = true, device = TV_1080p)
@Composable
fun AppPreview() {
    App()
}