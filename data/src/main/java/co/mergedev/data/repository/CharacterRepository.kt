package co.mergedev.data.repository

import co.mergedev.data.api.marvel.characters.IMarvelCharactersService
import co.mergedev.domain.common.AppFailure
import co.mergedev.domain.common.AppResult
import co.mergedev.domain.model.Character
import co.mergedev.domain.repository.ICharacterRepository

/**
 * TODO: document repository
 */
class CharacterRepository(
    private val charactersService: IMarvelCharactersService
) : ICharacterRepository {

    override suspend fun listCharacters(): AppResult<AppFailure, List<Character>> {

        val result = charactersService.charactersList()

        if (result.isSuccessful)
            result.body()?.let {
                return AppResult.Success(it.data.results)
            }


        return AppResult.Failure(AppFailure.ServerError)
    }

    override suspend fun detailCharacter(id: Long): AppResult<AppFailure, Character> {

        val result = charactersService.characterDetail(id)

        if (result.isSuccessful)
            result.body()?.let {
                return AppResult.Success(it.data.results.first())
            }

        return AppResult.Failure(AppFailure.ServerError)
    }
}