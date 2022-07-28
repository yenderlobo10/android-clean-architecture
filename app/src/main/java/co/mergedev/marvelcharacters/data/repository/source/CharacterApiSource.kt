package co.mergedev.marvelcharacters.data.repository.source

import co.mergedev.marvelcharacters.data.api.common.ApiResult
import co.mergedev.marvelcharacters.data.model.CharacterDataWrapper

/**
 * TODO: document
 */
interface CharacterApiSource {

    suspend fun listCharacters(): ApiResult<CharacterDataWrapper>

    suspend fun detailCharacter(
        id: Long
    ): ApiResult<CharacterDataWrapper>
}