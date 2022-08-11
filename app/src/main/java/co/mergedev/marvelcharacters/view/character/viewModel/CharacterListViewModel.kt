package co.mergedev.marvelcharacters.view.character.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.mergedev.data.api.marvel.MarvelApiClient
import co.mergedev.data.api.marvel.characters.MarvelCharacterService
import co.mergedev.data.repository.CharacterRepository
import co.mergedev.domain.common.AppResult
import co.mergedev.domain.usecase.character.ListCharactersUseCase
import co.mergedev.marvelcharacters.view.character.state.CharacterListScreenState
import kotlinx.coroutines.launch

/**
 * TODO: document
 */
class CharacterListViewModel : ViewModel() {

    private val marvelApi = MarvelApiClient()
    private val charactersService = MarvelCharacterService(marvelApi)
    private val characterRepository = CharacterRepository(charactersService)
    private val listCharacters = ListCharactersUseCase(characterRepository)

    var screenState by mutableStateOf(CharacterListScreenState())
        private set

    init {
        viewModelScope.launch {
            loadCharacters()
        }
    }


    private suspend fun loadCharacters() {

        listCharacters {

            screenState = when (it) {

                is AppResult.Success -> screenState.success().copy(
                    listCharacters = it.value
                )

                else -> screenState.error()
            }
        }
    }
}