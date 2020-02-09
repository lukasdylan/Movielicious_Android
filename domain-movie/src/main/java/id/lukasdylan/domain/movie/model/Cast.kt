package id.lukasdylan.domain.movie.model

/**
 * Created by lukasdylan on 2020-02-08
 */
data class Cast(
    val id: Int,
    val name: String,
    val characterName: String,
    val gender: Int,
    val profilePath: String
)