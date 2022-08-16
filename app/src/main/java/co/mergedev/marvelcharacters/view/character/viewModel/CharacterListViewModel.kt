package co.mergedev.marvelcharacters.view.character.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.mergedev.domain.common.AppResult
import co.mergedev.domain.usecase.character.ListCharactersUseCase
import co.mergedev.marvelcharacters.view.character.state.CharacterListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * TODO: document
 */
@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val listCharacters: ListCharactersUseCase
) : ViewModel() {

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