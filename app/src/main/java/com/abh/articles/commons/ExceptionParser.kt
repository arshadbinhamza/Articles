package com.abh.articles.commons

import com.abh.articles.R
import retrofit2.HttpException

object ExceptionParser {

    fun getMessage(exception: Exception): Int {
        return when (exception) {
            is HttpException -> getHttpErrorMessage(exception)
            else -> R.string.request_cannot_be_processed
        }
    }

    private fun getHttpErrorMessage(exception: HttpException): Int {
        return when (exception.code()) {
            404 -> R.string.network_error_not_founrd
            503 -> R.string.network_error_internal_server_error
            403 -> R.string.network_error_unauthorized
            else -> R.string.request_cannot_be_processed
        }
    }

}