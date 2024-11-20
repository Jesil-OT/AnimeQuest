package com.jesil.animequest.core.data.networking

import com.jesil.animequest.core.domain.utils.NetworkError
import com.jesil.animequest.core.domain.utils.Result
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

suspend inline fun <reified T> responseToResult(
    httpResponse: HttpResponse
): Result<T, NetworkError> {
    return when(httpResponse.status.value){
        in 200..299 -> {
            try {
                val data = httpResponse.body<T>()
                return Result.Success(data)
            } catch (e: NoTransformationFoundException) {
                Result.Error(NetworkError.SERIALIZATION_ERROR)
            }
        }
        400 -> Result.Error(NetworkError.BAD_REQUEST)
        401 -> Result.Error(NetworkError.UNAUTHORIZED)
        403 -> Result.Error(NetworkError.FORBIDDEN)
        404 -> Result.Error(NetworkError.NOT_FOUND)
        429 -> Result.Error(NetworkError.TOO_MANY_REQUESTS)
        in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
        else -> Result.Error(NetworkError.UNKNOWN_ERROR)
    }
}