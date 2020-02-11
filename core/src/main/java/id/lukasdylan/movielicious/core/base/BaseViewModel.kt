package id.lukasdylan.movielicious.core.base

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * Created by lukasdylan on 2020-01-01
 */
abstract class BaseViewModel<State : ViewState, Action : ViewAction, SideEffect : ViewSideEffect>(
    initialState: State
) : ViewModel() {

    private var currentViewState: State = initialState

    private val viewAction = MutableLiveData<Action>()
    val viewState: LiveData<State> =
        Transformations.map(Transformations.switchMap(viewAction, ::handleAction)) {
            renderViewState(it).updateCurrentViewState()
        }

    private val statelessAction = MutableLiveData<StatelessViewAction>()
    val viewSideEffect: LiveData<SideEffect> =
        Transformations.switchMap(statelessAction, ::handleAction)

    @MainThread
    fun execute(action: Action) = when (action) {
        is StatelessViewAction -> statelessAction.value = action
        else -> viewAction.value = action
    }

    protected fun getCurrentViewState(): State = currentViewState
    protected abstract fun renderViewState(result: UseCaseResult?): State
    protected abstract fun handleAction(action: Action): LiveData<UseCaseResult>
    protected open fun handleAction(action: StatelessViewAction): LiveData<SideEffect> =
        viewSideEffect

    private fun State.updateCurrentViewState(): State = this.also {
        currentViewState = it
    }
}
