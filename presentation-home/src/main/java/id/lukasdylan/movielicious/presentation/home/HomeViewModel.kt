package id.lukasdylan.movielicious.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import id.lukasdylan.domain.movie.usecase.GetDiscoverMovieList
import id.lukasdylan.domain.movie.usecase.GetDiscoverMovieListResult
import id.lukasdylan.movielicious.core.base.BaseViewModel
import id.lukasdylan.movielicious.core.base.UseCaseResult
import id.lukasdylan.movielicious.core.base.ViewSideEffect
import id.lukasdylan.movielicious.core.extension.call
import javax.inject.Inject

/**
 * Created by lukasdylan on 2020-02-01
 */
class HomeViewModel @Inject constructor(private val getDiscoverMovieList: GetDiscoverMovieList) :
    BaseViewModel<HomeViewState, HomeAction, ViewSideEffect>(initialState = HomeViewState()) {

    override fun renderViewState(result: UseCaseResult?): HomeViewState {
        return when (result) {
            is GetDiscoverMovieListResult -> result.mapGetDiscoverMovieListResult()
            else -> getCurrentViewState()
        }
    }

    override fun handleAction(action: HomeAction): LiveData<UseCaseResult> =
        liveData(viewModelScope.coroutineContext) {
            when (action) {
                is HomeAction.LoadDiscoverList -> {
                    call(getDiscoverMovieList.getResult())
                }
            }
        }

    private fun GetDiscoverMovieListResult.mapGetDiscoverMovieListResult(): HomeViewState {
        return when (this) {
            is GetDiscoverMovieListResult.Success -> {
                getCurrentViewState().copy(
                    data = this.data,
                    isLoading = false)
            }
            is GetDiscoverMovieListResult.Failed -> {
                getCurrentViewState().copy(
                    errorMessage = this.reason,
                    isLoading = false
                )
            }
        }
    }
}