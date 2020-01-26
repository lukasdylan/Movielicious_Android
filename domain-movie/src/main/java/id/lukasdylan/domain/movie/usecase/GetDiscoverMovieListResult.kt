package id.lukasdylan.domain.movie.usecase

import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.core.base.UseCaseResult

/**
 * Created by lukasdylan on 2020-01-26
 */
sealed class GetDiscoverMovieListResult : UseCaseResult() {

    data class Success(val data: List<Movie>) : GetDiscoverMovieListResult()
    data class Failed(val reason: String) : GetDiscoverMovieListResult()
}