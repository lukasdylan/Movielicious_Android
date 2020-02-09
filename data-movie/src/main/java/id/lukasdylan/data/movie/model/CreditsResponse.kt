package id.lukasdylan.data.movie.model

import androidx.annotation.Keep
import com.squareup.moshi.JsonClass

/**
 * Created by lukasdylan on 2020-02-08
 */
@Keep
@JsonClass(generateAdapter = true)
data class CreditsResponse(
    val cast: List<CastResponse>? = null,
    val crew: List<CrewResponse>? = null
)