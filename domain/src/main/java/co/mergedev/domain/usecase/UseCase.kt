package co.mergedev.domain.usecase

import co.mergedev.domain.common.AppFailure
import co.mergedev.domain.common.AppResult


abstract class UseCase<out T, in Params> where T : Any {

    abstract fun run(params: Params): AppResult<AppFailure, T>

    suspend operator fun invoke(
        params: Params,
        onResult: (AppResult<AppFailure, T>) -> Unit = {}
    ) {
    }

    class None
}