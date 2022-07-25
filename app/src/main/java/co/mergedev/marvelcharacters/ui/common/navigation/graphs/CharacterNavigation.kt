package co.mergedev.marvelcharacters.ui.common.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import co.mergedev.marvelcharacters.ui.character.view.CharacterDetailScreen
import co.mergedev.marvelcharacters.ui.character.view.CharacterListScreen
import co.mergedev.marvelcharacters.ui.common.navigation.routes.AppRoute
import co.mergedev.marvelcharacters.ui.main.AppState


/**
 * Define composable navigation graph to **character** in nav-host.
 */
fun NavGraphBuilder.characterNavigation(
    appState: AppState
) {

    navigation(
        startDestination = "/",
        route = AppRoute.CharacterList.name
    ) {

        composable(
            route = "/"
        ) {
            CharacterListScreen()
        }

        composable(
            route = AppRoute.CharacterDetail.name
        ) {
            CharacterDetailScreen()
        }
    }
}