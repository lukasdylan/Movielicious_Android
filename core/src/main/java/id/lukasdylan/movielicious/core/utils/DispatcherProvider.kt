package id.lukasdylan.movielicious.core.utils

import androidx.annotation.VisibleForTesting
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi

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

@ExperimentalCoroutinesApi
@VisibleForTesting
class TestDispatcherProviderImpl : DispatcherProvider {
    override fun background(): CoroutineDispatcher = Dispatchers.Unconfined
    override fun default(): CoroutineDispatcher = Dispatchers.Unconfined
}
