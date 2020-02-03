package id.lukasdylan.movielicious

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import id.lukasdylan.movielicious.core.extension.initTimber
import id.lukasdylan.movielicious.core.ui.initCoil

/**
 * Created by lukasdylan on 2020-01-13
 */
@Suppress("unused")
class MovieliciousApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initCoil()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .build().also {
                it.inject(this)
            }
    }
}
