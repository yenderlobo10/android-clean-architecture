package co.mergedev.domain.common

/**
 * TODO: document sealed class
 *
 * @see Failure
 * @see Success
 */
sealed class AppResult<out L, out R> {

    /**
     * TODO: document
     *
     * @param value
     */
    data class Failure<out L>(
        val value: L
    ) : AppResult<L, Nothing>()

    /**
     * TODO: document
     *
     * @param value
     */
    data class Success<out R>(
        val value: R
    ) : AppResult<Nothing, R>()


    /**
     * Returns true if this is [Failure], otherwise false.
     */
    val isFailure get() = this is Failure<L>

    /**
     * Returns true if this is [Success], otherwise false.
     */
    val isSuccess get() = this is Success<R>


    /**
     * Create a [AppResult.Failure] type.
     */
    fun <L> failure(value: L) = Failure(value)

    /**
     * Create a [AppResult.Success] type.
     */
    fun <R> success(value: R) = Success(value)
}
