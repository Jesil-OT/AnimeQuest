package com.jesil.animequest.core.presentation.utils

import android.content.Context
import com.jesil.animequest.R
import com.jesil.animequest.core.domain.utils.NetworkError

infix fun NetworkError.toLocalizedString(context: Context): String{
    val resId = when (this) {
        NetworkError.REQUEST_TIMEOUT -> R.string.request_timeout
        NetworkError.BAD_REQUEST -> R.string.bad_request
        NetworkError.UNAUTHORIZED -> R.string.unathorized
        NetworkError.FORBIDDEN -> R.string.error_unknown
        NetworkError.NOT_FOUND -> R.string.not_found
        NetworkError.TOO_MANY_REQUESTS -> R.string.too_many_requests
        NetworkError.NO_INTERNET_CONNECTION -> R.string.no_internet_connection
        NetworkError.SERVER_ERROR -> R.string.error_unknown
        NetworkError.SERIALIZATION_ERROR -> R.string.serialization_error
        NetworkError.UNKNOWN_ERROR -> R.string.error_unknown
    }
    return context.getString(resId)
}