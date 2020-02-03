package id.lukasdylan.movielicious.core.extension

import id.lukasdylan.movielicious.core.utils.Event

/**
 * Created by lukasdylan on 2020-01-01
 */

inline fun <T> Event<T>?.onContentChanged(crossinline listener: (T) -> Unit) {
    this?.getContentIfNotHandled()?.let(listener)
}