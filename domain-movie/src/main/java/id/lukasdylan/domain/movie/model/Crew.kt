package id.lukasdylan.domain.movie.model

/**
 * Created by lukasdylan on 2020-02-08
 */
data class Crew(
    val id: Int,
    val name: String,
    val job: String,
    val gender: Int,
    val profilePath: String
)