package co.mergedev.domain.usecase

import co.mergedev.domain.common.AppFailure
import co.mergedev.domain.common.AppResult

/**
 * Abstract class to represent a Use Case that takes no params.
 *
 * ```
 * * Any Use Case that takes no params in the application should
 *   implement this contract.
 */
abstract class UseCaseWithoutParams<out T> where T : Any {

    suspend operator fun invoke(
        onResult: (AppResult<AppFailure, T>) -> Unit = {}
    ) = onResult(run())


    abstract suspend fun run(): AppResult<AppFailure, T>
}