package co.mergedev.marvelcharacters.view.launch

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import co.mergedev.marvelcharacters.R
import co.mergedev.marvelcharacters.ui.navigation.routes.AppRoute
import co.mergedev.marvelcharacters.ui.theme.AppTheme
import co.mergedev.marvelcharacters.view.main.AppState
import co.mergedev.marvelcharacters.view.main.rememberAppState
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds


@Composable
fun LaunchScreen(
    appState: AppState
) {

    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.marve_bg_logo),
                contentDescription = "marvel-bg-logo"
            )
        }
    }

    LaunchedEffect(Unit) {
        delay(1.seconds)
        appState.navController.navigate(
            AppRoute.CharacterList.name
        ) {
            popUpTo(AppRoute.Launch.name) { inclusive = true }
        }
    }
}


@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun LaunchScreenPrev() {
    AppTheme {
        LaunchScreen(
            appState = rememberAppState()
        )
    }
}