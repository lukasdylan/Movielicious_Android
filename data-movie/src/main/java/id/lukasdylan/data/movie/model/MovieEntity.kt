package id.lukasdylan.data.movie.model

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by lukasdylan on 2020-01-25
 */
@Keep
@JsonClass(generateAdapter = true)
data class MovieEntity(
    val id: Int?,
    val title: String?,
    @Json(name = "vote_average") val voteAverage: Double?,
    @Json(name = "poster_path") val posterPath: String?,
    val genres: List<GenreEntity>?,
    val overview: String?,
    @Json(name = "release_date") val releaseDate: String?
)