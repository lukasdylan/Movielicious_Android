package id.lukasdylan.movielicious.core.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import id.lukasdylan.movielicious.core.utils.ViewModelFactory

/**
 * Created by lukasdylan on 2020-01-24
 */
@Module
internal abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}