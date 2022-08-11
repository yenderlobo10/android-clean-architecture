package co.mergedev.marvelcharacters.view.character.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import co.mergedev.data.api.marvel.MarvelApiClient
import co.mergedev.data.api.marvel.characters.MarvelCharacterService
import co.mergedev.data.repository.CharacterRepository
import co.mergedev.domain.common.AppResult
import co.mergedev.domain.usecase.character.DetailCharacterUseCase
import co.mergedev.marvelcharacters.view.character.state.CharacterDetailScreenState

/**
 * TODO: document
 */
class CharacterDetailViewModel : ViewModel() {

    private val marvelApi = MarvelApiClient()
    private val charactersService = MarvelCharacterService(marvelApi)
    private val characterRepository = CharacterRepository(charactersService)
    private val detailCharacter = DetailCharacterUseCase(characterRepository)

    var screenState by mutableStateOf(CharacterDetailScreenState())
        private set


    suspend fun loadCharacterDetail(
        characterId: Long?
    ) {

        detailCharacter(
            params = DetailCharacterUseCase.Params(
                id = characterId
            )
        ) {

            screenState = when (it) {

                is AppResult.Success -> screenState.success().copy(
                    character = it.value
                )

                else -> screenState.error()
            }
        }
    }
}