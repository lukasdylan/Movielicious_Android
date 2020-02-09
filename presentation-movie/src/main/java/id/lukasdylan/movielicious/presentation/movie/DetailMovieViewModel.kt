package id.lukasdylan.movielicious.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import id.lukasdylan.domain.movie.usecase.GetCreditsMovie
import id.lukasdylan.domain.movie.usecase.GetCreditsMovieResult
import id.lukasdylan.domain.movie.usecase.GetDetailMovie
import id.lukasdylan.domain.movie.usecase.GetDetailMovieResult
import id.lukasdylan.movielicious.core.base.BaseViewModel
import id.lukasdylan.movielicious.core.base.UseCaseResult
import id.lukasdylan.movielicious.core.base.ViewSideEffect
import id.lukasdylan.movielicious.core.extension.call
import id.lukasdylan.movielicious.core.utils.Event
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by lukasdylan on 2020-02-04
 */
class DetailMovieViewModel @Inject constructor(
    private val getDetailMovie: GetDetailMovie,
    private val getCreditsMovie: GetCreditsMovie
) : BaseViewModel<DetailMovieViewState, DetailMovieAction, ViewSideEffect>(initialState = DetailMovieViewState()) {

    override fun renderViewState(result: UseCaseResult?): DetailMovieViewState {
        return when (result) {
            is GetDetailMovieResult -> result.mapGetDetailMovieResult()
            is GetCreditsMovieResult -> result.mapGetCreditsMovieResult()
            else -> getCurrentViewState()
        }
    }

    override fun handleAction(action: DetailMovieAction): LiveData<UseCaseResult> =
        liveData(viewModelScope.coroutineContext) {
            when (action) {
                is DetailMovieAction.LoadMovieData -> {
                    val movieId = action.movieId
                    coroutineScope {
                        delay(250)
                        launch {
                            call(getDetailMovie.getResult(movieId))
                        }
                        launch {
                            call(getCreditsMovie.getResult(movieId))
                        }
                    }
                }
            }
        }

    private fun GetDetailMovieResult.mapGetDetailMovieResult(): DetailMovieViewState {
        return when (this) {
            is GetDetailMovieResult.Success -> {
                getCurrentViewState().copy(movieData = Event(this.data), isLoading = false)
            }
            is GetDetailMovieResult.Failed -> {
                getCurrentViewState()
            }
        }
    }

    private fun GetCreditsMovieResult.mapGetCreditsMovieResult(): DetailMovieViewState {
        return when (this) {
            is GetCreditsMovieResult.Success -> {
                getCurrentViewState().copy(
                    castList = Event(this.castList),
                    crewList = Event(this.crewList)
                )
            }
            is GetCreditsMovieResult.Failed -> {
                getCurrentViewState()
            }
        }
    }
}