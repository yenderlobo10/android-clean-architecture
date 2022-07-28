package co.mergedev.marvelcharacters.ui.common.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import co.mergedev.marvelcharacters.ui.character.view.CharacterDetailScreen
import co.mergedev.marvelcharacters.ui.character.view.CharacterListScreen
import co.mergedev.marvelcharacters.ui.common.navigation.routes.AppRoute
import co.mergedev.marvelcharacters.ui.common.navigation.routes.CharacterDetailRoute
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