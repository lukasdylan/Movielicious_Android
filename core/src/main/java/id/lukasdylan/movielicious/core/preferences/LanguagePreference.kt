package id.lukasdylan.movielicious.core.preferences

import android.app.Application
import android.content.Context
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Qualifier

/**
 * Created by lukasdylan on 2020-01-25
 */

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class LanguagePreferences

class LanguagePreference @Inject constructor(application: Application) : Preference<String> {

    private val sharedPreferences by lazy {
        application.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    override suspend fun getValue(): String {
        return sharedPreferences?.getString(KEY, LANGUAGE_ENGLISH) ?: LANGUAGE_ENGLISH
    }

    override suspend fun setValue(value: String) {
        sharedPreferences?.edit {
            putString(KEY, value)
        }
    }

    companion object {
        private const val PREFERENCE_NAME = "language_preference"
        private const val KEY = "language"
        const val LANGUAGE_ENGLISH = "en-US"
        const val LANGUAGE_BAHASA = "id-ID"
    }
}