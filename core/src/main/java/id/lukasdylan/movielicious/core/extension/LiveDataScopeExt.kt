package id.lukasdylan.movielicious.core.extension

import androidx.lifecycle.LiveDataScope
import id.lukasdylan.movielicious.core.base.UseCaseResult
import id.lukasdylan.movielicious.core.base.ViewSideEffect

/**
 * Created by lukasdylan on 2020-01-01
 */
suspend fun LiveDataScope<UseCaseResult>.callUseCase(block: UseCaseResult) {
    emit(block)
}

suspend fun <T : ViewSideEffect> LiveDataScope<T>.callSideEffect(block: T) {
    emit(block)
}
