package id.lukasdylan.movielicious.core.extension

import android.app.Application
import coil.Coil
import coil.ImageLoader
import coil.util.CoilUtils
import id.lukasdylan.movielicious.core.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import timber.log.Timber.DebugTree
import java.util.concurrent.TimeUnit

/**
 * Created by lukasdylan on 2020-01-14
 */
fun Application.initTimber() {
    if (BuildConfig.DEBUG) {
        Timber.plant(DebugTree())
    }
}

fun Application.initCoil() {
    val loggerInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Timber.tag("Image Request").d(message)
        }
    }).also {
        it.redactHeader("Authorization")
        it.redactHeader("Cookies")
        it.level = HttpLoggingInterceptor.Level.BASIC
    }
    val coilOkHttpClient = OkHttpClient.Builder().also {
        it.addInterceptor(loggerInterceptor)
        it.connectTimeout(30, TimeUnit.SECONDS)
        it.readTimeout(30, TimeUnit.SECONDS)
        it.cache(CoilUtils.createDefaultCache(this))
    }.build()

    Coil.setDefaultImageLoader {
        ImageLoader(this) {
            crossfade(true)
            okHttpClient(coilOkHttpClient)
        }
    }
}
