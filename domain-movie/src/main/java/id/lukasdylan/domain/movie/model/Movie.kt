package id.lukasdylan.domain.movie.model

import android.annotation.SuppressLint
import id.lukasdylan.data.movie.BuildConfig
import id.lukasdylan.movielicious.core.utils.Constant

/**
 * Created by lukasdylan on 2020-01-26
 */
data class Movie(
    val id: Int,
    val title: String,
    val rating: Double,
    val voteCount: Int,
    val posterUrl: String,
    val backdropUrl: String,
    val overview: String,
    val releaseDate: String,
    val genres: List<Genre>,
    val runtime: Int
) {

    @SuppressLint("DefaultLocale")
    fun getListOfGenreNames(): String =
        genres.asSequence().map { it.name }.toList().joinToString(separator = ", ") {
            it.capitalize()
        }

    fun getFullPathPosterUrl(): String = posterUrl.takeIf { it.isNotBlank() }?.let {
        "${BuildConfig.MOVIE_IMAGE_BASE_URL}${Constant.MOVIE_POSTER_SIZE}$it"
    }.orEmpty()

    fun getFullPathBackdropUrl(): String = backdropUrl.takeIf { it.isNotBlank() }?.let {
        "${BuildConfig.MOVIE_IMAGE_BASE_URL}${Constant.MOVIE_BACKDROP_SIZE}$it"
    }.orEmpty()

    fun getDurationText(): String {
        return if (runtime >= 60) {
            val hour = runtime.div(60)
            val minutes = runtime.rem(60)
            "${hour}h ${minutes}m"
        } else {
            "${runtime}m"
        }
    }
}