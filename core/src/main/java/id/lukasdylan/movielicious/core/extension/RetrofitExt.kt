package id.lukasdylan.movielicious.core.extension

import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import kotlin.coroutines.resume
import id.lukasdylan.movielicious.core.utils.DataResult

/**
 * Created by lukasdylan on 2020-01-25
 */
suspend fun <T : Any> Call<T>.awaitResult(): DataResult<T> {
    return suspendCancellableCoroutine { continuation ->
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>?, response: Response<T>) {
                continuation.resumeWith(runCatching {
                    if (response.isSuccessful) {
                        val body = response.body()
                        if (body == null) {
                            DataResult.Exception(NullPointerException("Response body is null"))
                        } else {
                            DataResult.Success(body)
                        }
                    } else {
                        DataResult.Error(HttpException(response))
                    }
                })
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                // Don't bother with resuming the continuation if it is already cancelled.
                if (continuation.isCancelled) return
                continuation.resume(DataResult.Exception(t))
            }
        })

        continuation.invokeOnCancellation {
            try {
                cancel()
            } catch (ex: Throwable) {
                //Ignore cancel exception
            }
        }
    }
}