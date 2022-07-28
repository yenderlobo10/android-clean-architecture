package co.mergedev.marvelcharacters.data.api.marvel.characters

import co.mergedev.marvelcharacters.data.api.marvel.MarvelApiClient

/**
 * TODO: document
 */
class MarvelApiCharactersClient private constructor() : MarvelApiClient() {


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