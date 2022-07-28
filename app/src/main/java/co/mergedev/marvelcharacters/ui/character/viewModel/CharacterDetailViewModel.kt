package co.mergedev.marvelcharacters.ui.character.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import co.mergedev.marvelcharacters.data.api.common.ApiResult
import co.mergedev.marvelcharacters.data.repository.CharacterRepository
import co.mergedev.marvelcharacters.ui.character.state.CharacterDetailScreenState
import timber.log.Timber

/**
 * TODO: document
 */
class CharacterDetailViewModel : ViewModel() {

    private val repository = CharacterRepository()

    var screenState by mutableStateOf(CharacterDetailScreenState())
        private set


    suspend fun loadCharacterDetail(characterId: Long?) {

        try {

            characterId?.let {
                if (characterId <= 0) throw IllegalArgumentException()
            }

            val result = repository.detailCharacter(
                id = characterId!!
            )

            screenState = when (result) {

                is ApiResult.Success -> screenState.success().copy(
                    character = result.body.data.results.first()
                )

                else -> screenState.error()
            }

        } catch (ex: Exception) {

            Timber.e(ex)
            screenState = screenState.error()
        }
    }
}