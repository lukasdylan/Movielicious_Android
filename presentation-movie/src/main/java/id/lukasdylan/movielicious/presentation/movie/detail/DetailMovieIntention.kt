package id.lukasdylan.movielicious.presentation.movie.detail

import id.lukasdylan.domain.movie.model.Cast
import id.lukasdylan.domain.movie.model.Crew
import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.core.base.*
import id.lukasdylan.movielicious.core.utils.Event

/**
 * Created by lukasdylan on 2020-02-04
 */
data class DetailMovieViewState(
    val movieData: Event<Movie>? = null,
    val castList: Event<List<Cast>>? = null,
    val crewList: Event<List<Crew>>? = null,
    val isLoading: Boolean = true
) : ViewState()

sealed class DetailMovieAction : ViewAction {
    data class LoadMovieData(val movieId: Int) : DetailMovieAction()
}