package id.lukasdylan.movielicious.core.ui

import android.app.Application
import android.view.View
import coil.Coil
import coil.ImageLoader
import coil.util.CoilUtils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * Created by lukasdylan on 2020-01-31
 */
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

fun View.dpToPx(dp: Int): Int {
    return ViewUtils.dpToPx(context, dp)
}