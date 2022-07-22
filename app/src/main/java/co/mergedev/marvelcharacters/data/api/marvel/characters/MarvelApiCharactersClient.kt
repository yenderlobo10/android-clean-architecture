package co.mergedev.marvelcharacters.data.api.marvel.characters

import co.mergedev.marvelcharacters.data.api.marvel.MarvelApiClient

/**
 * TODO: document
 */
class MarvelApiCharactersClient private constructor() : MarvelApiClient() {

    override val baseUrl: String
        get() = super.baseUrl.plus("characters")


    private fun createService(): MarvelApiCharactersService =
        createRetrofitBuilder()
            .client(super.httpClient)
            .build()
            .create(MarvelApiCharactersService::class.java)


    companion object {

        /**
         * TODO: document
         */
        fun create() = MarvelApiCharactersClient().createService()
    }
}