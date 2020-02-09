package id.lukasdylan.movielicious.presentation.home

import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.core.base.ViewAction
import id.lukasdylan.movielicious.core.base.ViewState

/**
 * Created by lukasdylan on 2020-02-01
 */
data class HomeViewState(
    val data: List<Movie> = emptyList(),
    val errorMessage: String? = null,
    val isLoading: Boolean = true
) : ViewState()

sealed class HomeAction : ViewAction() {
    object LoadDiscoverList : HomeAction()
}