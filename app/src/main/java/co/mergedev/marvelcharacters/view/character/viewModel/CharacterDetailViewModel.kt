package co.mergedev.marvelcharacters.view.character.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import co.mergedev.domain.common.AppResult
import co.mergedev.domain.usecase.character.DetailCharacterUseCase
import co.mergedev.marvelcharacters.view.character.state.CharacterDetailScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * TODO: document
 */
@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val detailCharacter: DetailCharacterUseCase
) : ViewModel() {

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