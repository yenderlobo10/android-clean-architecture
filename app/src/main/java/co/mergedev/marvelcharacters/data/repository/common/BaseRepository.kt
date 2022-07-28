package co.mergedev.marvelcharacters.data.repository.common

import co.mergedev.marvelcharacters.data.api.common.ApiResult
import retrofit2.Response

/**
 * TODO: document
 */
abstract class BaseRepository {

    /**
     * TODO: document
     *
     * @param call
     */
    protected suspend fun <T> getResult(
        call: suspend () -> Response<T>
    ): ApiResult<T> {

        return try {

            createResponse(
                response = call()
            )

        } catch (ex: Exception) {

            ApiResult.Error(
                message = ex.message,
                exception = ex
            )
        }
    }


    //#region Private methods

    private fun <T> createResponse(
        response: Response<T>
    ): ApiResult<T> {

        return when {

            response.isSuccessful -> ApiResult.Success(
                response.body()!!
            )

            else -> ApiResult.Error(
                message = response.message(),
                code = response.code(),
                body = response.errorBody()
            )
        }
    }

    //#endregion
}