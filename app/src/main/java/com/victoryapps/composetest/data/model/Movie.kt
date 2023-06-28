
package com.victoryapps.composetest.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    var thumbnail: String = GenreTypes.Action.drawable,
    val media: String = url,
    val duration: String,
    val rating: Float
) {
    companion object {
        const val url =
            //"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
            "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8"
    }
}
