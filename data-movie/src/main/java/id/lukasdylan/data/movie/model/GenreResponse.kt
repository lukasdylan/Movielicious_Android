package id.lukasdylan.data.movie.model

import androidx.annotation.Keep
import com.squareup.moshi.JsonClass

/**
 * Created by lukasdylan on 2020-01-25
 */
@Keep
@JsonClass(generateAdapter = true)
data class GenreResponse(
    val id: Int? = 0,
    val name: String? = null
)