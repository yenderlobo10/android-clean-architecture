package co.mergedev.data.api.marvel.characters

import co.mergedev.data.api.marvel.MarvelApiClient

/**
 * TODO: document service
 */
class MarvelCharacterService(
    apiClient: MarvelApiClient
) : IMarvelCharactersService {

    private val apiService: IMarvelCharactersService by lazy {
        apiClient.retrofit().create(IMarvelCharactersService::class.java)
    }

    override suspend fun charactersList() = apiService.charactersList()

    override suspend fun characterDetail(id: Long) = apiService.characterDetail(id)
}