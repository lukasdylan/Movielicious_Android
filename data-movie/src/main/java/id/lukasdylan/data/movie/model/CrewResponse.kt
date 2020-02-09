package id.lukasdylan.data.movie.model

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by lukasdylan on 2020-02-08
 */
@Keep
@JsonClass(generateAdapter = true)
data class CrewResponse(
    val id: Int?,
    val name: String?,
    val job: String?,
    val gender: Int?,
    @Json(name = "profile_path") val profilePath: String?
)