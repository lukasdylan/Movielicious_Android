package id.lukasdylan.movielicious.core.di

import android.app.Application
import dagger.Module
import dagger.Provides
import id.lukasdylan.movielicious.core.preferences.LanguagePreference
import id.lukasdylan.movielicious.core.preferences.Preference
import javax.inject.Qualifier

/**
 * Created by lukasdylan on 2020-01-24
 */
@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class LanguagePreferences

@Module
internal class PreferenceModule {

    @Provides
    @LanguagePreferences
    fun provideLanguagePreference(application: Application): Preference<String> {
        return LanguagePreference(application)
    }
}
