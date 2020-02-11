package id.lukasdylan.movielicious

import androidx.lifecycle.LiveData

/**
 * Created by lukasdylan on 2020-02-11
 */
internal fun <T> testLiveData(liveData: LiveData<T>, testAction: (T?) -> Unit) {
    testAction.invoke(liveData.value)
}