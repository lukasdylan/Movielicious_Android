package id.lukasdylan.domain.movie.usecase

import id.lukasdylan.data.movie.datamanager.MovieDataManager
import id.lukasdylan.data.movie.model.CreditsResponse
import id.lukasdylan.domain.movie.mapper.castsTransforms
import id.lukasdylan.domain.movie.mapper.crewsTransforms
import id.lukasdylan.domain.movie.model.Cast
import id.lukasdylan.domain.movie.model.Crew
import id.lukasdylan.movielicious.core.base.BaseUseCase
import id.lukasdylan.movielicious.core.base.UseCaseResult
import id.lukasdylan.movielicious.core.utils.DataResult
import id.lukasdylan.movielicious.core.utils.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by lukasdylan on 2020-02-04
 */
class GetCreditsMovie @Inject constructor(
    private val movieDataManager: MovieDataManager,
    private val dispatcherProvider: DispatcherProvider
) : BaseUseCase<Int, DataResult<CreditsResponse>, GetCreditsMovieResult>(dispatcherProvider.background()) {

    override suspend fun execute(param: Int?): DataResult<CreditsResponse> {
        return movieDataManager.loadCreditsMovie(param ?: 0)
    }

    override suspend fun DataResult<CreditsResponse>.transformToUseCaseResult(): GetCreditsMovieResult {
        return when (this) {
            is DataResult.Success -> {
                val castData = withContext(dispatcherProvider.default()) {
                    this@transformToUseCaseResult.value.cast.castsTransforms()
                }
                val crewData = withContext(dispatcherProvider.default()) {
                    this@transformToUseCaseResult.value.crew.crewsTransforms()
                }
                GetCreditsMovieResult.Success(castData, crewData)
            }
            is DataResult.Error -> GetCreditsMovieResult.Failed(
                this.exception.message()
            )
            is DataResult.Exception -> GetCreditsMovieResult.Failed(
                this.throwable.localizedMessage.orEmpty()
            )
        }
    }
}

sealed class GetCreditsMovieResult : UseCaseResult() {
    data class Success(val castList: List<Cast>, val crewList: List<Crew>) : GetCreditsMovieResult()
    data class Failed(val reason: String) : GetCreditsMovieResult()
}