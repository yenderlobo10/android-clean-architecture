package co.mergedev.marvelcharacters.data.api

import retrofit2.Converter
import retrofit2.Retrofit

/**
 * Base to create api client services by [Retrofit].
 */
abstract class ApiClient {

    abstract val baseUrl: String

    abstract fun createConverterFactory(): Converter.Factory


    /**
     * Create an instance of [Retrofit.Builder].
     */
    fun createRetrofitBuilder() = Retrofit.Builder().apply {

        baseUrl(baseUrl)
        addConverterFactory(createConverterFactory())
    }
}