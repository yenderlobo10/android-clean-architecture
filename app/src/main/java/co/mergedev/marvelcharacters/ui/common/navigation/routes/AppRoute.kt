package co.mergedev.marvelcharacters.ui.common.navigation.routes

import androidx.navigation.NavArgument

/**
 * Enumerate routes to app navigation.
 * * Use with [AppNavHost] component.
 * * Simple routes defines here, but routes require more complexity
 * define as a separate sealed-class.
 *
 * @param name Route name.
 * @param arguments List of [NavArgument] pass to route.
 */
sealed class AppRoute(
    open val name: String,
    val arguments: List<NavArgument> = listOf()
) {

    /**
     * App initial screen route.
     */
    object Launch : AppRoute(name = "launch")

    /**
     * List character screen route.
     */
    object CharacterList : AppRoute(name = "character-list")

    /**
     * Detail character screen route.
     */
    object CharacterDetail : CharacterDetailRoute(name = "character-detail")
}
