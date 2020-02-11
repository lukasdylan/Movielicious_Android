package id.lukasdylan.data.movie.model

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by lukasdylan on 2020-01-25
 */
@Keep
@JsonClass(generateAdapter = true)
data class MovieResponse(
    val id: Int?,
    val title: String?,
    @Json(name = "vote_average") val voteAverage: Double?,
    @Json(name = "vote_count") val voteCount: Int?,
    @Json(name = "poster_path") val posterPath: String?,
    @Json(name = "backdrop_path") val backdropPath: String?,
    val genres: List<GenreResponse>?,
    val overview: String?,
    @Json(name = "release_date") val releaseDate: String?,
    val runtime: Int?
)