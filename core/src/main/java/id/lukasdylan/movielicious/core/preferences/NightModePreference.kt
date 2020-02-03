package id.lukasdylan.movielicious.core.preferences

import android.app.Application
import android.content.Context
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Qualifier

/**
 * Created by lukasdylan on 2020-01-31
 */
@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class NightModePreferences

class NightModePreference @Inject constructor(application: Application): Preference<Int> {

    private val sharedPreferences by lazy {
        application.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    override suspend fun getValue(): Int {
        return sharedPreferences?.getInt(KEY, MODE_NIGHT_NO) ?: MODE_NIGHT_NO
    }

    override suspend fun setValue(value: Int) {
        sharedPreferences?.edit {
            putInt(KEY, value)
        }
    }

    companion object {
        private const val PREFERENCE_NAME = "night_mode_preference"
        private const val KEY = "night_mode"

        const val MODE_NIGHT_FOLLOW_SYSTEM = -1
        const val MODE_NIGHT_NO = 1
        const val MODE_NIGHT_YES = 2
        const val MODE_NIGHT_AUTO_BATTERY = 3
    }
}