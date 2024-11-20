package com.jesil.animequest.core.domain.utils

enum class NetworkError: Error {
    REQUEST_TIMEOUT,
    BAD_REQUEST,
    UNAUTHORIZED,
    FORBIDDEN,
    NOT_FOUND,
    TOO_MANY_REQUESTS,
    NO_INTERNET_CONNECTION,
    SERVER_ERROR,
    SERIALIZATION_ERROR,
    UNKNOWN_ERROR
}