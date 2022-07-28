package co.mergedev.marvelcharacters.ui.common.navigation.routes

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class CharacterDetailRoute(

    name: String = "character-detail/{${Keys.argCharacterId}}",
    args: List<NamedNavArgument> = Keys.args

) : AppRoute(
    name = name,
    arguments = args
) {

    object Keys {

        val argCharacterId = "characterId"

        val args = listOf(
            navArgument(argCharacterId) { type = NavType.LongType }
        )
    }

    fun createRoutePath(characterId: Long): String =
        name.replace("{${Keys.argCharacterId}}", "$characterId")
}