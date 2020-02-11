package id.lukasdylan.domain.movie.model

import android.os.Parcelable
import id.lukasdylan.data.movie.BuildConfig
import id.lukasdylan.movielicious.core.utils.Constant
import kotlinx.android.parcel.Parcelize

/**
 * Created by lukasdylan on 2020-02-08
 */
@Parcelize
data class Cast(
    val id: Int,
    val name: String,
    val characterName: String,
    val gender: Int,
    val profilePath: String
) : Parcelable {

    fun getFullPathProfileUrl(): String = profilePath.takeIf { it.isNotBlank() }?.let {
        "${BuildConfig.MOVIE_IMAGE_BASE_URL}${Constant.PROFILE_PICTURE_SIZE}$it"
    }.orEmpty()
}