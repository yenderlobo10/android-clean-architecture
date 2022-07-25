package co.mergedev.marvelcharacters.ui.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.mergedev.marvelcharacters.ui.common.navigation.graphs.characterNavigation
import co.mergedev.marvelcharacters.ui.common.navigation.routes.AppRoute
import co.mergedev.marvelcharacters.ui.launch.LaunchScreen
import co.mergedev.marvelcharacters.ui.main.AppState


@Composable
fun AppNavigationHost(
    appState: AppState
) {

    NavHost(
        navController = appState.navController,
        startDestination = appState.startDestination.name
    )
    {

        // Launch
        composable(
            route = AppRoute.Launch.name
        ) {
            LaunchScreen(appState = appState)
        }

        // Character
        characterNavigation(appState = appState)
    }
}