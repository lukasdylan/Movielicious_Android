package id.lukasdylan.domain.movie.model

import android.annotation.SuppressLint

/**
 * Created by lukasdylan on 2020-01-26
 */
data class Movie(
    val id: Int,
    val title: String,
    val rating: Double,
    val posterUrl: String,
    val backdropUrl: String,
    val overview: String,
    val releaseDate: String,
    val genres: List<Genre>
) {

    @SuppressLint("DefaultLocale")
    fun getListOfGenreNames(): String =
        genres.asSequence().map { it.name }.toList().joinToString(separator = ", ") {
            it.capitalize()
        }
}