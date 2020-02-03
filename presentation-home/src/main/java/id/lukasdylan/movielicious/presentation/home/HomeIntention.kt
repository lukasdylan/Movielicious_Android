package id.lukasdylan.movielicious.presentation.home

import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.core.base.ViewAction
import id.lukasdylan.movielicious.core.base.ViewState
import id.lukasdylan.movielicious.core.utils.Event

/**
 * Created by lukasdylan on 2020-02-01
 */
data class HomeViewState(
    val data: Event<List<Movie>> = Event(emptyList()),
    val errorMessage: Event<String>? = null,
    val loadingState: Event<Boolean> = Event(true)
) : ViewState()

sealed class HomeAction : ViewAction() {
    object LoadDiscoverList : HomeAction()
}