package co.mergedev.domain.usecase

import co.mergedev.domain.common.AppFailure
import co.mergedev.domain.common.AppResult

/**
 * Abstract class to represent a Use Case with params.
 *
 * ```
 * * Any Use Case that takes params in the application should
 *   implement this contract.
 */
abstract class UseCaseWithParams<out T, in Params> where T : Any {

    abstract suspend fun run(
        params: Params
    ): AppResult<AppFailure, T>

    suspend operator fun invoke(
        params: Params,
        onResult: (AppResult<AppFailure, T>) -> Unit = {}
    ) = onResult(
        run(params)
    )
}