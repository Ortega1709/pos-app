package com.ortega.util

sealed class PosAppResult<T> (val data: T? = null, val message: String? = null) {

    class Success<T>(data: T?): PosAppResult<T>(data)
    class Error<T>(data: T?, message: String): PosAppResult<T>(data, message)
    class Loading<T>(): PosAppResult<T>()

}