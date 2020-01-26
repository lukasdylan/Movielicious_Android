package id.lukasdylan.movielicious.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import id.lukasdylan.domain.movie.usecase.GetDiscoverMovieList
import id.lukasdylan.domain.movie.usecase.GetDiscoverMovieListResult
import id.lukasdylan.movielicious.core.base.BaseViewModel
import id.lukasdylan.movielicious.core.base.UseCaseResult
import id.lukasdylan.movielicious.core.base.ViewSideEffect
import id.lukasdylan.movielicious.core.extension.call
import id.lukasdylan.movielicious.core.utils.Event
import javax.inject.Inject

/**
 * Created by lukasdylan on 2020-01-26
 */
class TestViewModel @Inject constructor(private val getDiscoverMovieList: GetDiscoverMovieList) :
    BaseViewModel<TestViewState, TestAction, ViewSideEffect>() {

    override var currentViewState: TestViewState = TestViewState()

    override fun mapIntoState(result: UseCaseResult): TestViewState {
        return when (result) {
            is GetDiscoverMovieListResult -> result.mapGetDiscoverMovieListResult()
            else -> currentViewState
        }
    }

    override fun handle(action: TestAction): LiveData<UseCaseResult> =
        liveData(viewModelScope.coroutineContext) {
            when (action) {
                is TestAction.LoadDiscoverList -> call(getDiscoverMovieList.getResult())
            }
        }

    private fun GetDiscoverMovieListResult.mapGetDiscoverMovieListResult(): TestViewState {
        return when (this) {
            is GetDiscoverMovieListResult.Success -> {
                currentViewState.copy(data = Event(this.data))
            }
            is GetDiscoverMovieListResult.Failed -> {
                currentViewState.copy(errorMessage = Event(this.reason))
            }
        }
    }
}