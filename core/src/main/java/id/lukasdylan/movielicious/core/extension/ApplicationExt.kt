package id.lukasdylan.movielicious.core.extension

import android.app.Application
import id.lukasdylan.movielicious.core.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree

/**
 * Created by lukasdylan on 2020-01-14
 */
@Suppress("unused")
fun Application.initTimber() {
    if (BuildConfig.DEBUG) {
        Timber.plant(DebugTree())
    }
}
