package co.mergedev.domain.common

/**
 * Enumerates api request results executing through retrofit client.
 */
sealed class AppFailure {

    /**
     * Indicate device is not internet connection.
     * TODO: implement Retrofit handler
     */
    object NonInternetConnection : AppFailure()

    /**
     * Indicate server response error.
     */
    object ServerError : AppFailure()

    /**
     * Extend to implement feature specific failures.
     * TODO: abstract class to extend
     */
    object FeatureFailure : AppFailure()
}
