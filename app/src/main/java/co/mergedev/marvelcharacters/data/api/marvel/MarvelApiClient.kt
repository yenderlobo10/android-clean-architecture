package co.mergedev.marvelcharacters.data.api.marvel

import co.mergedev.marvelcharacters.BuildConfig
import co.mergedev.marvelcharacters.common.extensions.toHashMD5
import co.mergedev.marvelcharacters.data.api.ApiClient
import co.mergedev.marvelcharacters.data.api.common.addLogger
import co.mergedev.marvelcharacters.data.api.common.addQueryParameters
import co.mergedev.marvelcharacters.data.api.common.createHttpClient
import co.mergedev.marvelcharacters.data.api.common.createMoshiConverterFactoryOrDefault
import co.mergedev.marvelcharacters.data.api.marvel.characters.MarvelApiCharactersClient

/**
 * TODO: document
 * @see <a href="https://developer.marvel.com/docs">developer.marvel.com</a>
 */
open class MarvelApiClient : ApiClient() {

    private val publicKey = BuildConfig.MARVEL_API_PUBLIC_KEY
    private val privateKey = BuildConfig.MARVEL_API_PRIVATE_KEY
    private val timestamp = System.currentTimeMillis().toString()

    private val defaultRequestsQueryParams = mapOf(
        "apikey" to publicKey,
        "ts" to timestamp,
        "hash" to "$timestamp$privateKey$publicKey".toHashMD5()
    )

    protected val httpClient = createHttpClient()
        .addQueryParameters(defaultRequestsQueryParams)
        .addLogger()
        .build()

    override val baseUrl = "https://gateway.marvel.com/v1/public/"

    override val converterFactory = createMoshiConverterFactoryOrDefault()


    companion object {

        /**
         * TODO: document
         */
        val characters = MarvelApiCharactersClient.create()
    }
}