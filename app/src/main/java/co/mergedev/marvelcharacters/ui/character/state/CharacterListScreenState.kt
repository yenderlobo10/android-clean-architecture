package co.mergedev.marvelcharacters.ui.character.state

import co.mergedev.marvelcharacters.data.model.Character

/**
 * TODO: document
 */
data class CharacterListScreenState(

    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val listCharacters: List<Character> = listOf()
) {

    fun error() = this.copy(isError = true, isLoading = false)

    fun success() = this.copy(isLoading = false, isError = false)
}
