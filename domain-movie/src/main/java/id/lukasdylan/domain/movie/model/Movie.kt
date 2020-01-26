package id.lukasdylan.domain.movie.model

/**
 * Created by lukasdylan on 2020-01-26
 */
data class Movie(
    val id: Int,
    val title: String,
    val rating: Double,
    val posterUrl: String,
    val overview: String,
    val releaseDate: String,
    val genres: List<String>
)