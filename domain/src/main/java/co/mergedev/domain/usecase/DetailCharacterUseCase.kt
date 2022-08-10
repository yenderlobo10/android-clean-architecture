package co.mergedev.domain.usecase

import co.mergedev.domain.common.AppFailure
import co.mergedev.domain.common.AppResult
import co.mergedev.domain.model.Character
import co.mergedev.domain.repository.ICharacterRepository

class DetailCharacterUseCase(
    private val repository: ICharacterRepository
) {

    suspend operator fun invoke(
        id: Long?,
        onResult: (AppResult<AppFailure, Character>) -> Unit
    ) {

        try {

            id?.let {
                if (id <= 0)
                    throw IllegalArgumentException()
            }

            onResult(repository.detailCharacter(id!!))

        } catch (ex: Exception) {

            onResult(AppResult.Failure(AppFailure.ServerError))
        }
    }
}