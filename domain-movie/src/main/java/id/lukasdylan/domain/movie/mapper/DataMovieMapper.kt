package id.lukasdylan.domain.movie.mapper

import id.lukasdylan.data.movie.BuildConfig
import id.lukasdylan.data.movie.model.CastResponse
import id.lukasdylan.data.movie.model.CrewResponse
import id.lukasdylan.data.movie.model.GenreResponse
import id.lukasdylan.data.movie.model.MovieResponse
import id.lukasdylan.domain.movie.model.Cast
import id.lukasdylan.domain.movie.model.Crew
import id.lukasdylan.domain.movie.model.Genre
import id.lukasdylan.domain.movie.model.Movie

/**
 * Created by lukasdylan on 2020-01-26
 */
fun List<MovieResponse>?.moviesTransforms(): List<Movie> {
    return this?.asSequence()?.map { it.movieTransform() }?.toList().orEmpty()
}

fun MovieResponse.movieTransform(): Movie {
    return Movie(
        id = this.id ?: 0,
        title = this.title.orEmpty(),
        rating = this.voteAverage ?: 0.0,
        overview = this.overview.orEmpty(),
        releaseDate = this.releaseDate.orEmpty(),
        posterUrl = "${BuildConfig.MOVIE_IMAGE_BASE_URL}w185${this.posterPath.orEmpty()}",
        backdropUrl = "${BuildConfig.MOVIE_IMAGE_BASE_URL}w300${this.backdropPath.orEmpty()}",
        genres = this.genres.genresTransforms()
    )
}

fun List<GenreResponse>?.genresTransforms(): List<Genre> {
    return this?.asSequence()?.map { it.genreTransform() }?.toList().orEmpty()
}

fun GenreResponse.genreTransform(): Genre {
    return Genre(id = this.id ?: 0, name = this.name.orEmpty())
}

fun List<CastResponse>?.castsTransforms(): List<Cast> {
    return this?.asSequence()?.map { it.castTransform() }?.toList().orEmpty()
}

fun CastResponse.castTransform(): Cast {
    return Cast(
        id = this.id ?: 0,
        name = this.name.orEmpty(),
        characterName = this.character.orEmpty(),
        gender = this.gender ?: -1,
        profilePath = "${BuildConfig.MOVIE_IMAGE_BASE_URL}w185${this.profilePath.orEmpty()}"
    )
}

fun List<CrewResponse>?.crewsTransforms(): List<Crew> {
    return this?.asSequence()?.map { it.crewTransform() }?.toList().orEmpty()
}

fun CrewResponse.crewTransform(): Crew {
    return Crew(
        id = this.id ?: 0,
        name = this.name.orEmpty(),
        job = this.job.orEmpty(),
        gender = this.gender ?: -1,
        profilePath = "${BuildConfig.MOVIE_IMAGE_BASE_URL}w185${this.profilePath.orEmpty()}"
    )
}