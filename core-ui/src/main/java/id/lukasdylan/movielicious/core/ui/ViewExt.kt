package id.lukasdylan.movielicious.core.ui

import android.app.Application
import android.graphics.drawable.Drawable
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.navigation.NavOptionsBuilder
import coil.Coil
import coil.ImageLoader
import coil.util.CoilUtils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.util.concurrent.TimeUnit
import kotlin.math.roundToInt

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
            placeholder(R.drawable.bg_loading_placeholder)
            error(R.drawable.icon_no_image)
            okHttpClient(coilOkHttpClient)
        }
    }
}

fun View.dpToPx(dp: Int): Int {
    val displayMetrics = context.resources.displayMetrics
    return (dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
}

fun NavOptionsBuilder.slideLeftRightAnim() {
    anim {
        enter = R.anim.slide_in_right
        exit = R.anim.slide_out_left
        popEnter = R.anim.slide_in_left
        popExit = R.anim.slide_out_right
    }
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide(stillHadSpace: Boolean = false) {
    visibility = if (stillHadSpace) View.INVISIBLE else View.GONE
}

fun View.withNoBackground() {
    withBackground(null)
}

fun View.withBackground(drawable: Drawable?) {
    background = drawable
}

fun ViewGroup.inflateView(@LayoutRes layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}