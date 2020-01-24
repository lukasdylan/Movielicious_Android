package id.lukasdylan.movielicious.core.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Created by lukasdylan on 2020-01-01
 */
abstract class BaseUseCase<RequestParam, ResponseObject, UseCaseResult>
    (private val dispatcher: CoroutineDispatcher) {

    protected abstract suspend fun execute(param: RequestParam?): ResponseObject

    protected abstract fun ResponseObject.transformToUseCaseResult(): UseCaseResult

    suspend fun getResult(param: RequestParam? = null): UseCaseResult {
        val executionResult = withContext(dispatcher) {
            execute(param)
        }
        return executionResult.transformToUseCaseResult()
    }
}
