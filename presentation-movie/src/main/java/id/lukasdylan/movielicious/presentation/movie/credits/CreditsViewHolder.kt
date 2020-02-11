package id.lukasdylan.movielicious.presentation.movie.credits

import android.view.View
import coil.api.load
import coil.transform.CircleCropTransformation
import id.lukasdylan.movielicious.core.ui.base.BaseViewHolder
import id.lukasdylan.movielicious.presentation.movie.R
import kotlinx.android.synthetic.main.item_movie_person_vertical.*

/**
 * Created by lukasdylan on 2020-02-09
 */
class CreditsViewHolder(view: View) : BaseViewHolder(view) {

    fun bind(name: String, description: String, profileUrl: String) {
        tv_name?.text = name
        tv_desc?.text = description

        iv_profile?.load(profileUrl) {
            placeholder(R.drawable.bg_circle_loading_placeholder)
            transformations(CircleCropTransformation())
        }
    }
}