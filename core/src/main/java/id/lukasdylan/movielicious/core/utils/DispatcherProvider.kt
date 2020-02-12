package id.lukasdylan.movielicious.core.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by lukasdylan on 2020-01-23
 */
interface DispatcherProvider {
    fun background(): CoroutineDispatcher
    fun default(): CoroutineDispatcher
}

class DispatcherProviderImpl : DispatcherProvider {
    override fun background(): CoroutineDispatcher = Dispatchers.IO
    override fun default(): CoroutineDispatcher = Dispatchers.Default
}
