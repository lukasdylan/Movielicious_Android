package id.lukasdylan.movielicious.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * Created by lukasdylan on 2020-01-01
 */
@Suppress("Unused", "MemberVisibilityCanBePrivate")
abstract class BaseViewModel<State : ViewState, Action : ViewAction, SideEffect : ViewSideEffect> :
    ViewModel() {

    protected abstract var currentViewState: State

    private val viewAction = MutableLiveData<Action>()
    val viewState: LiveData<State> =
        Transformations.map(Transformations.switchMap(viewAction, ::handle)) {
            mapIntoState(it).replaceState()
        }

    private val statelessAction = MutableLiveData<StatelessViewAction>()
    val viewSideEffect: LiveData<SideEffect> = Transformations.switchMap(statelessAction, ::handle)

    fun execute(action: Action) = when (action) {
        is StatelessViewAction -> statelessAction.value = action
        else -> viewAction.value = action
    }

    protected abstract fun mapIntoState(result: UseCaseResult): State
    protected abstract fun handle(action: Action): LiveData<UseCaseResult>
    protected open fun handle(action: StatelessViewAction): LiveData<SideEffect> = viewSideEffect

    private fun State.replaceState(): State = this.also {
        currentViewState = it
    }
}
