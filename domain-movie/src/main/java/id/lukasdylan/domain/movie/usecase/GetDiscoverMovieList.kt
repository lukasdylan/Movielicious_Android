package id.lukasdylan.domain.movie.usecase

import id.lukasdylan.data.movie.datamanager.MovieDataManager
import id.lukasdylan.data.movie.model.MovieListResponse
import id.lukasdylan.domain.movie.mapper.moviesTransforms
import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.core.base.BaseUseCase
import id.lukasdylan.movielicious.core.base.UseCaseResult
import id.lukasdylan.movielicious.core.utils.DataResult
import id.lukasdylan.movielicious.core.utils.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by lukasdylan on 2020-01-26
 */
class GetDiscoverMovieList @Inject constructor(
    private val movieDataManager: MovieDataManager,
    private val dispatcherProvider: DispatcherProvider
) : BaseUseCase<Nothing, DataResult<MovieListResponse>, GetDiscoverMovieListResult>(
    dispatcherProvider.background()
) {

    override suspend fun execute(param: Nothing?): DataResult<MovieListResponse> {
        return movieDataManager.loadDiscoverList()
    }

    override suspend fun DataResult<MovieListResponse>.transformToUseCaseResult(): GetDiscoverMovieListResult {
        return when (this) {
            is DataResult.Success -> {
                val data = withContext(dispatcherProvider.default()) {
                    this@transformToUseCaseResult.value.results.moviesTransforms()
                }
                GetDiscoverMovieListResult.Success(data)
            }
            is DataResult.Error -> GetDiscoverMovieListResult.Failed(
                this.exception.message()
            )
            is DataResult.Exception -> GetDiscoverMovieListResult.Failed(
                this.throwable.localizedMessage.orEmpty()
            )
        }
    }
}

sealed class GetDiscoverMovieListResult : UseCaseResult() {
    data class Success(val data: List<Movie>) : GetDiscoverMovieListResult()
    data class Failed(val reason: String) : GetDiscoverMovieListResult()
}
