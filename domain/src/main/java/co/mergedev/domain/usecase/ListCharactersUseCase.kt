package co.mergedev.domain.usecase

import co.mergedev.domain.common.AppFailure
import co.mergedev.domain.common.AppResult
import co.mergedev.domain.model.Character
import co.mergedev.domain.repository.ICharacterRepository

class ListCharactersUseCase(
    private val repository: ICharacterRepository
) {

    suspend operator fun invoke(
        onResult: (AppResult<AppFailure, List<Character>>) -> Unit
    ) {
        try {

            onResult(repository.listCharacters())

        } catch (ex: Exception) {

            onResult(AppResult.Failure(AppFailure.ServerError))
        }
    }
}