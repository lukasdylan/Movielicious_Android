package id.lukasdylan.movielicious.presentation.movie.detail

import id.lukasdylan.domain.movie.model.Cast
import id.lukasdylan.domain.movie.model.Movie

/**
 * Created by lukasdylan on 2020-02-05
 */
sealed class DetailMovieSection {
    abstract val viewType: Int

    companion object {
        const val MOVIE_HEADER_VIEW_TYPE = 0
        const val MOVIE_OVERVIEW_VIEW_TYPE = 1
        const val MOVIE_CAST_LIST_VIEW_TYPE = 2

        @JvmStatic
        fun getLayoutStructure(): MutableList<DetailMovieSection> =
            mutableListOf(
                MovieHeaderSection(),
                MovieOverviewSection(),
                MovieCastListSection()
            )

        @JvmStatic
        fun updateMovieHeaderData(movie: Movie): DetailMovieSection =
            MovieHeaderSection(
                movie
            )

        @JvmStatic
        fun updateMovieOverviewData(overview: String): DetailMovieSection =
            MovieOverviewSection(
                overview
            )

        @JvmStatic
        fun updateMovieCastListData(data: List<Cast>): DetailMovieSection =
            MovieCastListSection(
                data
            )
    }
}

data class MovieHeaderSection(val movie: Movie? = null) : DetailMovieSection() {

    override val viewType: Int
        get() = MOVIE_HEADER_VIEW_TYPE
}

data class MovieOverviewSection(val overview: String? = null) : DetailMovieSection() {

    override val viewType: Int
        get() = MOVIE_OVERVIEW_VIEW_TYPE
}

data class MovieCastListSection(val castList: List<Cast>? = null) : DetailMovieSection() {

    override val viewType: Int
        get() = MOVIE_CAST_LIST_VIEW_TYPE
}
