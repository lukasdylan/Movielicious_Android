package id.lukasdylan.movielicious.core.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by lukasdylan on 2020-01-24
 */
@Module
class PreferenceModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences("movielicious", Context.MODE_PRIVATE)
    }
}