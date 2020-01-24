package id.lukasdylan.movielicious.core.di

import dagger.Module
import dagger.Provides
import id.lukasdylan.movielicious.core.utils.DispatcherProvider
import id.lukasdylan.movielicious.core.utils.DispatcherProviderImpl
import javax.inject.Singleton

/**
 * Created by lukasdylan on 2020-01-24
 */
@Module
class DispatcherModule {

    @Provides
    @Singleton
    fun provideDispatcher(): DispatcherProvider = DispatcherProviderImpl()
}
