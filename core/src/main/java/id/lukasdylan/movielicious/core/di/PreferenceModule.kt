package id.lukasdylan.movielicious.core.di

import android.app.Application
import dagger.Module
import dagger.Provides
import id.lukasdylan.movielicious.core.preferences.*

/**
 * Created by lukasdylan on 2020-01-24
 */

@Module
internal class PreferenceModule {

    @Provides
    @LanguagePreferences
    fun provideLanguagePreference(application: Application): Preference<String> {
        return LanguagePreference(application)
    }

    @Provides
    @NightModePreferences
    fun provideNightModePreference(application: Application): Preference<Int> {
        return NightModePreference(application)
    }
}
