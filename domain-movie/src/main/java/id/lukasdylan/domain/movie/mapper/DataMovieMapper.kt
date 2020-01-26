package id.lukasdylan.domain.movie.mapper

import id.lukasdylan.data.movie.BuildConfig
import id.lukasdylan.data.movie.model.MovieEntity
import id.lukasdylan.domain.movie.model.Movie

/**
 * Created by lukasdylan on 2020-01-26
 */
fun List<MovieEntity>?.transforms(): List<Movie> {
    return this?.asSequence()?.map { it.transform() }?.toList().orEmpty()
}

fun MovieEntity.transform(): Movie {
    return Movie(
        id = this.id ?: 0,
        title = this.title.orEmpty(),
        rating = this.voteAverage ?: 0.0,
        overview = this.overview.orEmpty(),
        releaseDate = this.releaseDate.orEmpty(),
        posterUrl = "${BuildConfig.MOVIE_IMAGE_BASE_URL}w185${this.posterPath.orEmpty()}",
        genres = this.genres?.asSequence()?.map { it.name.orEmpty() }?.toList().orEmpty()
    )
}