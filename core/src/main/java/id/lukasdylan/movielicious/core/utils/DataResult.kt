package id.lukasdylan.movielicious.core.utils

import retrofit2.HttpException

/**
 * Created by lukasdylan on 2020-01-25
 */
sealed class DataResult<out T> {

    data class Success<T>(val value: T): DataResult<T>()
    data class Error(val exception: HttpException): DataResult<Nothing>()
    data class Exception(val throwable: Throwable): DataResult<Nothing>()
}