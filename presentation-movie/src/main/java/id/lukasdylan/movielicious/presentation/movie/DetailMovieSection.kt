package id.lukasdylan.movielicious.presentation.movie

import id.lukasdylan.domain.movie.model.Movie

/**
 * Created by lukasdylan on 2020-02-05
 */
sealed class DetailMovieSection {
    abstract val viewType: Int

    companion object {
        const val MOVIE_OVERVIEW_VIEW_TYPE = 0

        @JvmStatic
        fun getLayoutStructure(): MutableList<DetailMovieSection> =
            mutableListOf(MovieOverviewSection())

        @JvmStatic
        fun updateMovieOverviewData(movie: Movie): DetailMovieSection =
            MovieOverviewSection(movie, false)
    }
}

data class MovieOverviewSection(
    val movie: Movie? = null,
    val isLoading: Boolean = true
) : DetailMovieSection() {

    override val viewType: Int
        get() = MOVIE_OVERVIEW_VIEW_TYPE
}