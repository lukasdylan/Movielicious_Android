package id.lukasdylan.movielicious.test

import id.lukasdylan.domain.movie.model.Movie
import id.lukasdylan.movielicious.core.base.ViewAction
import id.lukasdylan.movielicious.core.base.ViewState
import id.lukasdylan.movielicious.core.utils.Event

/**
 * Created by lukasdylan on 2020-01-26
 */
data class TestViewState(
    val data: Event<List<Movie>> = Event(emptyList()),
    val errorMessage: Event<String>? = null
) : ViewState()

sealed class TestAction : ViewAction() {
    object LoadDiscoverList : TestAction()
}