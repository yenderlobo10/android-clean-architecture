package co.mergedev.domain.usecase.character

import co.mergedev.domain.common.AppFailure
import co.mergedev.domain.common.AppResult
import co.mergedev.domain.model.Character
import co.mergedev.domain.repository.ICharacterRepository
import co.mergedev.domain.usecase.UseCaseWithParams
import co.mergedev.domain.usecase.character.DetailCharacterUseCase.Params

/**
 * Use case to get a [Character] detail from repository.
 *
 * @param repository
 */
class DetailCharacterUseCase(
    private val repository: ICharacterRepository
) : UseCaseWithParams<Character, Params>() {

    override suspend fun run(
        params: Params
    ): AppResult<AppFailure, Character> {

        return try {

            params.id?.let {
                if (params.id <= 0)
                    throw IllegalArgumentException()
            }

            repository.detailCharacter(params.id!!)

        } catch (ex: Exception) {

            AppResult.Failure(AppFailure.ServerError)
        }
    }


    data class Params(
        val id: Long?
    )
}