package co.mergedev.data.api.marvel

import co.mergedev.data.BuildConfig
import co.mergedev.data.api.ApiClient
import co.mergedev.data.api.common.createHttpClient
import co.mergedev.data.api.common.createMoshiConverterFactoryOrDefault
import co.mergedev.data.extensions.addLogger
import co.mergedev.data.extensions.addQueryParameters
import co.mergedev.framework.extension.toHashMD5

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


    override val httpClient = createHttpClient()
        .addQueryParameters(defaultRequestsQueryParams)
        .addLogger()
        .build()

    override val baseUrl = "https://gateway.marvel.com/v1/public/"

    override val converterFactory = createMoshiConverterFactoryOrDefault()
}