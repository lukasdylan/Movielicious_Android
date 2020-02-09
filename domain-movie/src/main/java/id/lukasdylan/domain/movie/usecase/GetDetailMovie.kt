package id.lukasdylan.domain.movie.usecase

import id.lukasdylan.data.movie.datamanager.MovieDataManager
import id.lukasdylan.data.movie.model.MovieResponse
import id.lukasdylan.domain.movie.mapper.movieTransform
import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.core.base.BaseUseCase
import id.lukasdylan.movielicious.core.base.UseCaseResult
import id.lukasdylan.movielicious.core.utils.DataResult
import id.lukasdylan.movielicious.core.utils.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by lukasdylan on 2020-02-04
 */
class GetDetailMovie @Inject constructor(
    private val movieDataManager: MovieDataManager,
    private val dispatcherProvider: DispatcherProvider
) : BaseUseCase<Int, DataResult<MovieResponse>, GetDetailMovieResult>(dispatcherProvider.background()) {

    override suspend fun execute(param: Int?): DataResult<MovieResponse> {
        return movieDataManager.loadDetailMovie(param ?: 0)
    }

    override suspend fun DataResult<MovieResponse>.transformToUseCaseResult(): GetDetailMovieResult {
        return when (this) {
            is DataResult.Success -> {
                val data = withContext(dispatcherProvider.default()) {
                    this@transformToUseCaseResult.value.movieTransform()
                }
                GetDetailMovieResult.Success(data)
            }
            is DataResult.Error -> GetDetailMovieResult.Failed(
                this.exception.message()
            )
            is DataResult.Exception -> GetDetailMovieResult.Failed(
                this.throwable.localizedMessage.orEmpty()
            )
        }
    }
}

sealed class GetDetailMovieResult : UseCaseResult() {
    data class Success(val data: Movie) : GetDetailMovieResult()
    data class Failed(val reason: String) : GetDetailMovieResult()
}