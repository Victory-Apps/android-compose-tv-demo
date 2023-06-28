package com.victoryapps.composetest

import VideoScreenArgs
import com.victoryapps.composetest.ui.details.DetailsScreenArgs

enum class Screens(val args: List<Any>? = null) {
    Home,
    Details(listOf(DetailsScreenArgs.movieId)),
    VideoPlayer(listOf(VideoScreenArgs.movieId));

    operator fun invoke(): String {
        val argList = StringBuilder()
        args?.let { nnArgs ->
            nnArgs.forEach { arg -> argList.append("/{$arg}") }
        }
        return name + argList
    }

    fun withArgs(vararg args: Any): String {
        val destination = StringBuilder()
        args.forEach { arg -> destination.append("/$arg") }
        return name + destination
    }
}