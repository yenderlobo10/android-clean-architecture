package co.mergedev.marvelcharacters.data.api.marvel.characters

import co.mergedev.marvelcharacters.data.model.CharacterDataWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Marvel api **characters** end-points contract.
 */
interface MarvelApiCharactersService {

    @GET("characters")
    suspend fun charactersList(): Response<CharacterDataWrapper>

    @GET("characters/{characterId}")
    suspend fun characterDetail(
        @Path("characterId") id: Long
    ): Response<CharacterDataWrapper>
}