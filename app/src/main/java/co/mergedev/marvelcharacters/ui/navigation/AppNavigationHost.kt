package co.mergedev.marvelcharacters.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.mergedev.marvelcharacters.ui.navigation.graphs.characterNavigation
import co.mergedev.marvelcharacters.ui.navigation.routes.AppRoute
import co.mergedev.marvelcharacters.view.launch.LaunchScreen
import co.mergedev.marvelcharacters.view.main.AppState


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