package id.lukasdylan.movielicious.core.di

import dagger.Module

/**
 * Created by lukasdylan on 2020-01-24
 */
@Module(includes = [DispatcherModule::class, NetworkModule::class,
    PreferenceModule::class, ViewModelModule::class])
class CoreModules