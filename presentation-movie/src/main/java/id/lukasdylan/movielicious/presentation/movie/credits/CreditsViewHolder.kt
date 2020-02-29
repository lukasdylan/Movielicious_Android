package id.lukasdylan.movielicious.presentation.movie.credits

import android.view.View
import coil.api.load
import coil.transform.CircleCropTransformation
import id.lukasdylan.domain.movie.model.Cast
import id.lukasdylan.movielicious.core.ui.base.BaseViewHolder
import id.lukasdylan.movielicious.presentation.movie.R
import kotlinx.android.synthetic.main.item_movie_person_vertical.*

/**
 * Created by lukasdylan on 2020-02-09
 */
class CreditsViewHolder(view: View) : BaseViewHolder<Cast>(view) {

    override fun bind(item: Cast) {
        tv_name?.text = item.name
        tv_desc?.text = item.characterName

        iv_profile?.load(item.getFullPathProfileUrl()) {
            placeholder(R.drawable.bg_circle_loading_placeholder)
            transformations(CircleCropTransformation())
        }
    }
}