import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import com.victoryapps.composetest.theme.ComposeTestTheme
import com.victoryapps.composetest.ui.video.VideoScreenViewModel

object VideoScreenArgs {
    const val movieId = "movieId"
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun VideoScreen(
    movieId: Int,
    modifier: Modifier,
) {
    val viewModel: VideoScreenViewModel = hiltViewModel()
    ComposeTestTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
        ) {

        }
    }
}

@Preview(showBackground = true, device = Devices.TV_1080p)
@Composable
fun VideoScreenPreview() {
    VideoScreen(1, Modifier)
}
