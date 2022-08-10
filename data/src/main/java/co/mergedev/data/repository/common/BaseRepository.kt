package co.mergedev.data.repository.common

import co.mergedev.domain.common.AppFailure
import co.mergedev.domain.common.AppResult
import retrofit2.Response

/**
 * TODO: document
 */
@Deprecated("Experimental use")
abstract class BaseRepository {

    /**
     * TODO: document
     *
     * @param call
     */
    protected suspend fun <T> getResult(
        call: suspend () -> Response<T>
    ): AppResult<AppFailure, T> {

        return try {

            createResponse(
                response = call()
            )

        } catch (ex: Exception) {

            AppResult.Failure(AppFailure.ServerError)
        }
    }


    //#region Private methods

    private fun <T> createResponse(
        response: Response<T>
    ): AppResult<AppFailure, T> {

        return when {

            response.isSuccessful -> AppResult.Success(response.body()!!)

            else -> AppResult.Failure(AppFailure.ServerError)
        }
    }

    //#endregion
}