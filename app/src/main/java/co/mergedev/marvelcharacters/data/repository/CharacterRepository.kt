package co.mergedev.marvelcharacters.data.repository

import co.mergedev.marvelcharacters.data.api.marvel.MarvelApiClient
import co.mergedev.marvelcharacters.data.repository.common.BaseRepository
import co.mergedev.marvelcharacters.data.repository.source.CharacterApiSource

/**
 * TODO: document
 */
class CharacterRepository : BaseRepository(), CharacterApiSource {

    override suspend fun listCharacters() = getResult {
        MarvelApiClient.characters.charactersList()
    }

    override suspend fun detailCharacter(id: Long) = getResult {
        MarvelApiClient.characters.characterDetail(id)
    }
}