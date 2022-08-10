package co.mergedev.domain.repository

import co.mergedev.domain.common.AppFailure
import co.mergedev.domain.common.AppResult
import co.mergedev.domain.model.Character

/**
 * TODO: document repository
 */
interface ICharacterRepository {

    suspend fun listCharacters(): AppResult<AppFailure, List<Character>>

    suspend fun detailCharacter(
        id: Long
    ): AppResult<AppFailure, Character>
}