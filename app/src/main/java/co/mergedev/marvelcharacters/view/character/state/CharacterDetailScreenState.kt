package co.mergedev.marvelcharacters.view.character.state

import co.mergedev.domain.model.Character

/**
 * TODO: document
 */
data class CharacterDetailScreenState(

    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val character: Character? = null
){

    fun error() = this.copy(isError = true, isLoading = false)

    fun success() = this.copy(isLoading = false, isError = false)
}
