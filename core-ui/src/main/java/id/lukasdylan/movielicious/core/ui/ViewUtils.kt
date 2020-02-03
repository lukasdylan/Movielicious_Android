package id.lukasdylan.movielicious.core.ui

import android.content.Context
import android.util.DisplayMetrics
import kotlin.math.roundToInt

/**
 * Created by lukasdylan on 2020-02-01
 */
object ViewUtils {

    fun dpToPx(context: Context, dp: Int): Int {
        val displayMetrics = context.resources.displayMetrics
        return (dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
    }
}