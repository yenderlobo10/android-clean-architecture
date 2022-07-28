package co.mergedev.marvelcharacters.data.api.common

import okhttp3.ResponseBody

/**
 * Enumerates api request results executing through retrofit client.
 */
sealed class ApiResult<out T> {

    /**
     * Indicate device is not internet connection.
     * TODO: implement Retrofit handler
     */
    object NonInternetConnection : ApiResult<Nothing>()

    /**
     * Denote request is successfully.
     *
     * @param body Response body <[T]> returned.
     */
    data class Success<out T>(val body: T) : ApiResult<T>()

    /**
     * Denote request returned an exception.
     *
     * @param message Optional - Error short description.
     * @param code Optional - Ref. code of error (ej. HTTP Status code).
     * @param exception Optional - exception object.
     */
    data class Error(
        val message: String?,
        val code: Int? = null,
        val exception: Exception? = null,
        val body: ResponseBody? = null
    ) : ApiResult<Nothing>()
}
