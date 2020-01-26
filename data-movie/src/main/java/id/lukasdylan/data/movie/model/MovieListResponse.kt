package id.lukasdylan.data.movie.model

import androidx.annotation.Keep

/**
 * Created by lukasdylan on 2020-01-25
 */
@Keep
data class MovieListResponse(val results: List<MovieEntity>? = null)
