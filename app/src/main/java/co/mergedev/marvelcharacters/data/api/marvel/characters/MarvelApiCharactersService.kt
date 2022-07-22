package co.mergedev.marvelcharacters.data.api.marvel.characters

import co.mergedev.marvelcharacters.data.model.CharacterDataWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Marvel api **characters** end-points contract.
 */
interface MarvelApiCharactersService {

    @GET
    suspend fun characters(): Response<CharacterDataWrapper>

    @GET("/{characterId}")
    suspend fun character(
        @Path("characterId") id: Long
    ): Response<CharacterDataWrapper>
}