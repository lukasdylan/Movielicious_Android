package id.lukasdylan.movielicious

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import id.lukasdylan.data.movie.module.DataMovieModule
import id.lukasdylan.movielicious.core.di.CoreModules
import id.lukasdylan.movielicious.presentation.home.HomeModule
import id.lukasdylan.movielicious.presentation.movie.detail.DetailMovieModule
import javax.inject.Singleton

/**
 * Created by lukasdylan on 2020-01-24
 */
@Singleton
@Component(
    modules = [AndroidInjectionModule::class, CoreModules::class, DataMovieModule::class,
        HomeModule::class, DetailMovieModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}