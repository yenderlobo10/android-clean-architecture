package co.mergedev.marvelcharacters.ui.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import co.mergedev.marvelcharacters.view.character.screen.CharacterDetailScreen
import co.mergedev.marvelcharacters.view.character.screen.CharacterListScreen
import co.mergedev.marvelcharacters.ui.navigation.routes.AppRoute
import co.mergedev.marvelcharacters.ui.navigation.routes.CharacterDetailRoute
import co.mergedev.marvelcharacters.view.main.AppState


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

        // List
        composable(
            route = "/"
        ) {
            CharacterListScreen(
                appState = appState
            )
        }

        // Detail
        with(AppRoute.CharacterDetail) {
            composable(
                route = name,
                arguments = arguments
            ) {
                CharacterDetailScreen(
                    appState = appState,
                    characterId = it.arguments?.getLong(
                        CharacterDetailRoute.Keys.argCharacterId
                    )
                )
            }
        }
    }
}