package co.mergedev.domain.usecase.character

import co.mergedev.domain.common.AppFailure
import co.mergedev.domain.common.AppResult
import co.mergedev.domain.model.Character
import co.mergedev.domain.repository.ICharacterRepository
import co.mergedev.domain.usecase.UseCaseWithoutParams

/**
 * Use case to get list of [Character] from repository.
 *
 * @param repository
 */
class ListCharactersUseCase(
    private val repository: ICharacterRepository
) : UseCaseWithoutParams<List<Character>>() {

    override suspend fun run(): AppResult<AppFailure, List<Character>> {

        return try {

            repository.listCharacters()

        } catch (ex: Exception) {

            AppResult.Failure(AppFailure.ServerError)
        }
    }
}