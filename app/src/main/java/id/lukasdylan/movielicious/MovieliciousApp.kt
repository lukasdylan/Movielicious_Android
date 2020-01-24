package id.lukasdylan.movielicious

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import id.lukasdylan.movielicious.core.extension.initCoil
import id.lukasdylan.movielicious.core.extension.initTimber

/**
 * Created by lukasdylan on 2020-01-13
 */
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
