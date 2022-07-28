package co.mergedev.marvelcharacters.ui.character.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.mergedev.marvelcharacters.data.api.common.ApiResult
import co.mergedev.marvelcharacters.data.repository.CharacterRepository
import co.mergedev.marvelcharacters.ui.character.state.CharacterListScreenState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.time.Duration.Companion.seconds

/**
 * TODO: document
 */
class CharacterListViewModel : ViewModel() {

    private val repository = CharacterRepository()

    var screenState by mutableStateOf(CharacterListScreenState())
        private set

    init {
        // TODO
        viewModelScope.launch {
            loadCharacters()
        }
    }


    suspend fun loadCharacters() {

        try {

            val result = repository.listCharacters()

            screenState = when (result) {

                is ApiResult.Success -> screenState.success().copy(
                    listCharacters = result.body.data.results
                )

                else -> screenState.error()
            }

        } catch (ex: Exception) {

            Timber.e(ex)
            screenState = screenState.error()
        }
    }
}