package id.lukasdylan.movielicious.presentation.movie

import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import id.lukasdylan.domain.movie.usecase.GetCreditsMovie
import id.lukasdylan.domain.movie.usecase.GetCreditsMovieResult
import id.lukasdylan.domain.movie.usecase.GetDetailMovie
import id.lukasdylan.domain.movie.usecase.GetDetailMovieResult
import id.lukasdylan.movielicious.core.base.BaseViewModel
import id.lukasdylan.movielicious.core.base.StatelessViewAction
import id.lukasdylan.movielicious.core.base.UseCaseResult
import id.lukasdylan.movielicious.core.extension.callSideEffect
import id.lukasdylan.movielicious.core.extension.callUseCase
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
) : BaseViewModel<DetailMovieViewState, DetailMovieAction, DetailMovieViewSideEffect>(initialState = DetailMovieViewState()) {

    override fun renderViewState(result: UseCaseResult?): DetailMovieViewState {
        return when (result) {
            is GetDetailMovieResult -> result.mapGetDetailMovieResult()
            is GetCreditsMovieResult -> result.mapGetCreditsMovieResult()
            else -> getCurrentViewState()
        }
    }

    override fun handleAction(action: DetailMovieAction) =
        liveData<UseCaseResult>(viewModelScope.coroutineContext) {
            when (action) {
                is DetailMovieAction.LoadMovieData -> {
                    val movieId = action.movieId
                    coroutineScope {
                        delay(250)
                        launch {
                            callUseCase(getDetailMovie.getResult(movieId))
                        }
                        launch {
                            callUseCase(getCreditsMovie.getResult(movieId))
                        }
                    }
                }
            }
        }

    override fun handleAction(action: StatelessViewAction) =
        liveData<DetailMovieViewSideEffect>(viewModelScope.coroutineContext) {
            when (action) {
                is DetailMovieAction.OpenDetailOverviewScreen -> {
                    val overview =
                        getCurrentViewState().movieData?.peekContent()?.overview.orEmpty()
                    callSideEffect(DetailMovieViewSideEffect.navigateToDetailOverview(overview))
                }
                is DetailMovieAction.OpenCastCreditsScreen -> {
                    val castList = getCurrentViewState().castList?.peekContent().orEmpty()
                    callSideEffect(DetailMovieViewSideEffect.navigateToCastCredits(castList))
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